package com.noodles.redis.v1.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisCluster;

/**
 *
 * 文件名：RedisConfig.java
 * 描述：redis工具类
 * 作者：eric
 * 日期：2018年12月3日上午9:51:04
 */
@Configuration
public class RedisConfig {

	/**redis集群节点*/
	@Value("${spring.redis.cluster.nodes}")
	private String clusterNodes;


	/**
	 * Redisson集群配置
	 * @return org.redisson.api.RedissonClient
	 * @author eric
	 * @date 2019/6/3 8:48
	 */
	@Bean
	public RedissonClient getRedisson(){
		String[] nodes  = clusterNodes.split(",");
		/** 集群的ip前面要加上"redis://"*/
		for(int i=0;i<nodes.length;i++){
			nodes[i] = "redis://"+nodes[i];
		}
		RedissonClient redisson = null;
		Config config = new Config();
		config.useClusterServers()
				.setScanInterval(2000)
				.setIdleConnectionTimeout(10000)
				.addNodeAddress(nodes);
		redisson = Redisson.create(config);
		/**可通过打印redisson.getConfig().toJSON().toString()来检测是否配置成功*/
		return redisson;
	}

}
