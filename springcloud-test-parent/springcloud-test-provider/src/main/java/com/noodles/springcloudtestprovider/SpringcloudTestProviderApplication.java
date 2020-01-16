package com.noodles.springcloudtestprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.noodles.springcloudtestprovider", "com.noodles.security", "com.noodles.redis" })
@MapperScan(basePackages = { "com.noodles.springcloudtestprovider.springbootmybatis.dao" })
public class SpringcloudTestProviderApplication {
	/**
	 * 启动方法
	 * @param args 参数
	 * @return
	 * @author 巫威
	 * @date 2019/8/22 15:05
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudTestProviderApplication.class, args);
	}
}
