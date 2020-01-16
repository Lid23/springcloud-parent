package com.noodles.gateway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

import com.netflix.loadbalancer.IRule;
import com.noodles.gateway.filter.RibbonFilter;
import com.noodles.log.MySlf4j;

/**
 * @filename CreditGatewayApplication
 * @description
 * @author Eric
 * @date 2019/4/3 8:49
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.noodles.gateway", "com.noodles.redis", "com.noodles.security"})
@MapperScan(basePackages = { "com.noodles.gateway.dao"})
public class SpingcloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingcloudGatewayApplication.class, args);
		MySlf4j.textInfo("微服务-网关-启动完成");
	}

	/**z
	 * 负载均衡策略
	 * @return com.netflix.loadbalancer.IRule
	 * @author Eric
	 * @date 2019/9/19 11:07
	 */
	@Bean
	@Scope("prototype")
	public IRule RibbonyRule() {
		// 指定策略：负载均衡策略
		return new RibbonFilter();
	}
}
