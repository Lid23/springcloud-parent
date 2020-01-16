package com.noodles.springcloudtestclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages={"com.noodles.springcloudtestfeign.service"})
public class SpringcloudTestClientApplication {
	/**
	 * 启动方法
	 * @param args 参数
	 * @return
	 * @author 巫威
	 * @date 2019/8/22 15:05
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudTestClientApplication.class, args);
	}
}
