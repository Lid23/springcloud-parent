package com.noodles.admin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

import com.uaf.log.MySlf4j;

/**
 * @filename MicroserviceAdminApplication
 * @description Spring Boot Admin监控启动类
 * @autor Eric
 * @date 2019/8/29 9:34
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
@ComponentScan(basePackages = { "com.noodles.admin", "com.noodles.security" })
public class MicroserviceAdminApplication implements CommandLineRunner {

	/**
	 * 启动项目
	 * @param args
	 * @return void
	 * @author Eric
	 * @date 2019/8/29 10:10
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAdminApplication.class, args);
	}

	@Override
	public void run(String... args) {
		MySlf4j.textInfo("服务已启动!");
	}
}
