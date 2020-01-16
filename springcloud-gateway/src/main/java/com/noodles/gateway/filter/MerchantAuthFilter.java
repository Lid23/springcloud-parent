package com.noodles.gateway.filter;

import io.netty.buffer.ByteBufAllocator;

import java.net.URI;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.noodles.api.exception.MicroserviceException;
import com.noodles.api.exception.MicroserviceServiceException;
import com.noodles.api.vo.req.BaseReqVo;
import com.noodles.api.vo.resp.BaseRespVo;
import com.noodles.common.constant.utils.GlobalConstantParamUtils;
import com.noodles.common.json.utils.JsonUtils;
import com.noodles.common.response.utils.ResponseUtils;
import com.noodles.gateway.service.IMerchantAuthService;
import com.noodles.log.MySlf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** @filename MerchantAuthFilter
 *  @description 商户请求认证
 *  @author Eric
 *  @date 2019/4/4 14:36 */
@Component
public class MerchantAuthFilter implements GlobalFilter, Ordered {

	/**认证通商户认证*/
	@Autowired
	private IMerchantAuthService merchantAuthService;

	/** redis服务 */
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 商户访问权限验证过滤器
	 * @param exchange e
	 * @param chain c
	 * @return reactor.core.publisher.Mono<java.lang.Void>
	 * @author Eric
	 * @date 2019/4/4 14:45
	 */
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		/** 验证商户是否有权限访问 */
		ServerHttpRequest serverHttpRequest = exchange.getRequest();
		String token = serverHttpRequest.getHeaders().get("token").get(0);
		String bodyStr = stringRedisTemplate.opsForValue().get("microservice:gateway:".concat(token));
		String clientIp = exchange.getRequest().getHeaders().getFirst("X-Real-IP");
		BaseReqVo baseReqVo = JsonUtils.fromJson(bodyStr, BaseReqVo.class);
		//将IP设置为从http请求头中获取的远端地址
		baseReqVo.setIp(clientIp);
		try {
			// 商户认证
			BaseRespVo<?> baseRespVo = merchantAuthService.checkMerchantAuth(baseReqVo);
			if (GlobalConstantParamUtils.RESULT_CODE_SUCC.equals(baseRespVo.getCode())) {
				// 若验证成功，将信息重新写入避免request信息消费后后续无法从request获取信息的问题
				URI uri = serverHttpRequest.getURI();
				ServerHttpRequest request = serverHttpRequest.mutate().uri(uri).build();
				DataBuffer bodyDataBuffer = stringBuffer(bodyStr);
				Flux<DataBuffer> bodyFlux = Flux.just(bodyDataBuffer);
				request = new ServerHttpRequestDecorator(request) {
					@Override
					public Flux<DataBuffer> getBody() {
						return bodyFlux;
					}
				};
				// 封装request，传给下一级
				return chain.filter(exchange.mutate().request(request).build());
			} else {
				// 若验证不成功，返回提示信息
				return gatewayResponse(baseRespVo.getCode(), baseRespVo.getMessage(), exchange);
			}
		} catch (MicroserviceServiceException ex) {
			// 若验证不成功，返回提示信息
			MySlf4j.textError("商户访问权限验证异常，异常代码:{0},异常信息:{1}, 异常{2}", ex.getCode(), ex.getMessage(), ex);
			return gatewayResponse(ex.getCode(), ex.getMessage(), exchange);
		} catch (Exception ex) {
			MySlf4j.textError("商户访问权限验证服务异常:{0}", MySlf4j.ExceptionToString(ex));
			return gatewayResponse(MicroserviceException.ERR_100000, "系统异常", exchange);
		} finally {
			stringRedisTemplate.delete("microservice:gateway:".concat(token));
		}
	}

	/**
	 * 优先级
	 * @return int 数字越大优先级越低
	 * @author Eric
	 * @date 2019/4/4 13:36
	 */
	@Override
	public int getOrder() {
		return 2;
	}

	/**
	 * 从Flux<DataBuffer>中获取字符串的方法
	 * @param serverHttpRequest 请求参数
	 * @return java.lang.String
	 * @author Eric
	 * @date 2019/4/4 14:42
	 */
	private String resolveBodyFromRequest(ServerHttpRequest serverHttpRequest) {
		// 获取请求体
		Flux<DataBuffer> body = serverHttpRequest.getBody();
		AtomicReference<String> bodyRef = new AtomicReference<>();
		body.subscribe(new Consumer<DataBuffer>() {
			@Override
			public void accept(DataBuffer buffer) {
				CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer.asByteBuffer());
				DataBufferUtils.release(buffer);
				bodyRef.set(charBuffer.toString());
			}
		});
		// 获取request body
		return bodyRef.get();
	}

	/**
	 * 数据流处理方法
	 * @param value 参数
	 * @return org.springframework.core.io.buffer.DataBuffer
	 * @author Eric
	 * @date 2019/4/4 14:43
	 */
	private DataBuffer stringBuffer(String value) {
		byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
		NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(ByteBufAllocator.DEFAULT);
		DataBuffer buffer = nettyDataBufferFactory.allocateBuffer(bytes.length);
		buffer.write(bytes);
		return buffer;
	}

	/**
	 * 网关请求响应
	 * @param code 返回代码
	 * @param message 返回消息
	 * @param exchange e
	 * @return reactor.core.publisher.Mono<java.lang.Void>
	 * @author Eric
	 * @date 2019/4/17 12:45
	 */
	private Mono<Void> gatewayResponse(String code, String message, ServerWebExchange exchange) {
		// 若验证不成功，返回提示信息
		ServerHttpResponse response = exchange.getResponse();
		BaseRespVo<Object> baseRespVo = ResponseUtils.responseMsg(code, message, null);
		byte[] bits = JsonUtils.toJson(baseRespVo).getBytes(StandardCharsets.UTF_8);
		DataBuffer buffer = response.bufferFactory().wrap(bits);
		response.setStatusCode(HttpStatus.UNAUTHORIZED);
		// 指定编码，否则在浏览器中会中文乱码
		response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
		return response.writeWith(Mono.just(buffer));
	}
}
