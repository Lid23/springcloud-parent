package com.noodles.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;


@SpringBootApplication
@EnableEurekaServer
@EnableApolloConfig
public class SpringcloudEurekaApolloApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurekaApolloApplication.class, args);
	}

}
