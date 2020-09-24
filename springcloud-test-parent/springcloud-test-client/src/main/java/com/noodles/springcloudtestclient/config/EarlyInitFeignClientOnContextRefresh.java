package com.noodles.springcloudtestclient.config;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.noodles.logback.MySlf4j;

/**
 * @filename EarlyInitFeignClientOnContextRefresh
 * @description 模拟第一次请求，初始化feign client
 * @author 巫威
 * @date 2020/9/24 14:50
 */
@Component
public class EarlyInitFeignClientOnContextRefresh implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired()
	@Qualifier("cachingLBClientFactory")
	CachingSpringLoadBalancerFactory factory;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ApplicationContext applicationContext = event.getApplicationContext();
		Map<String, Object> beans = applicationContext.getBeansWithAnnotation(FeignClient.class);
		for (Map.Entry<String, Object> entry :
				beans.entrySet()) {
			Class<?> clazz = entry.getValue().getClass();
			try {
				Method method = null;
				method = clazz.getMethod("heartbeat");
				method.invoke(entry.getValue());
				MySlf4j.textWarn("init feign client:  " + clazz.getName());
			} catch (NoSuchMethodException e) {
				MySlf4j.textWarn("init feign client fail: no method of heartbeat in " + clazz.getName());
			} catch (IllegalAccessException e) {
				MySlf4j.textWarn("init feign client fail: IllegalAccessException of " + clazz.getName());
			} catch (InvocationTargetException e) {
				MySlf4j.textWarn("init feign client fail: InvocationTargetException of " + clazz.getName());
			} catch (Exception e){
				MySlf4j.textError(MySlf4j.ExceptionToString(e));
			}
		}

		MySlf4j.textInfo("init feign client done!");
	}
}


