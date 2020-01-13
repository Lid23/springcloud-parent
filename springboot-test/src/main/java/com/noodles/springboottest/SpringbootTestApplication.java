package com.noodles.springboottest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 百行provider启动类
 * @filename BaihangCreditApplication
 * @author 巫威
 * @date 2019/8/12 18:09
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.noodles.springboottest", "com.noodles.redis" })
@MapperScan(basePackages = { "com.noodles.springboottest.springbootmybatis.dao" })
public class SpringbootTestApplication {
	/**
	 * 启动方法
	 * @param args 参数
	 * @return
	 * @author 巫威
	 * @date 2019/8/22 15:05
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringbootTestApplication.class, args);
	}
}
