package com.noodles.gateway.filter;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.noodles.common.security.utils.Base64Utils;
import com.noodles.log.MySlf4j;
import reactor.core.publisher.Mono;

/**
 * @filename OAuthSignatureFilter
 * @description OAUTH授权过滤器
 * @author Eric
 * @date 2019/4/3 10:03
 */
@Component
public class OAuthSignatureFilter implements GlobalFilter, Ordered {

	/**授权访问用户名*/
	@Value("${spring.security.user.name}")
	private String securityUserName;
	/**授权访问密码*/
	@Value("${spring.security.user.password}")
	private String securityUserPassword;

	/**
	 * OAuth过滤器
	 * @param exchange
	 * @param chain
	 * @return reactor.core.publisher.Mono<java.lang.Void>
	 * @author Eric
	 * @date 2019/4/4 13:36
	 */
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		/**oauth授权*/
		String auth = securityUserName.concat(":").concat(securityUserPassword);
		String encodedAuth = null;
		try {
			encodedAuth = Base64Utils.encode(auth.getBytes(Charset.forName("US-ASCII")));
		} catch (UnsupportedEncodingException e) {
			MySlf4j.textError("BASE64编码异常:{0}",MySlf4j.ExceptionToString(e));
		}
		String authHeader = "Basic " + encodedAuth;
		//向headers中放授权信息
		ServerHttpRequest serverHttpRequest = exchange.getRequest().mutate().header("Authorization", authHeader)
				.build();
		//将现在的request变成change对象
		ServerWebExchange build = exchange.mutate().request(serverHttpRequest).build();
		return chain.filter(build);
	}

	/**
	 * 优先级
	 * @return int 数字越大优先级越低
	 * @author Eric
	 * @date 2019/4/4 13:36
	 */
	@Override
	public int getOrder() {
		return 3;
	}

}
