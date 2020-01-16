package com.noodles.gateway.filter;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.DefaultServerRequest;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.noodles.log.MySlf4j;
import reactor.core.publisher.Mono;

/**
 * @filename RequestFilter
 * @description 请求过滤器
 * @autor Eric
 * @date 2019/5/21 13:45
 */
@Component
public class RequestFilter implements GlobalFilter, Ordered {

	/** redis服务 */
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		DefaultServerRequest req = new DefaultServerRequest( exchange );
		String token = UUID.randomUUID().toString();
		//向headers中放入token信息
		ServerHttpRequest serverHttpRequest = exchange.getRequest().mutate().header( "token", token ).build();
		//将现在的request变成change对象
		ServerWebExchange build = exchange.mutate().request( serverHttpRequest ).build();
		return req.bodyToMono( String.class ).map( str -> {
			stringRedisTemplate.opsForValue().set( "microservice:gateway:".concat( token ), str, 18, TimeUnit.SECONDS);
			String clientIp = exchange.getRequest().getHeaders().getFirst("X-Real-IP");
			MySlf4j.textInfo("请求网关地址:{0},客户端IP:{1}", serverHttpRequest.getPath().pathWithinApplication(), clientIp);
			return str;
		} ).then( chain.filter( build ) );
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
