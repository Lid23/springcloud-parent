package com.noodles.gateway.filter;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;
import com.noodles.log.MySlf4j;

/**
 * @filename RibbonFilter
 * @description 负载均衡过滤器
 * @autor Eric
 * @date 2019/9/12 11:47
 */
public class RibbonFilter extends AbstractLoadBalancerRule {

	/**服务分组[all，server01,server02]*/
	@Value("${eureka.instance.metadata-map.group-name}")
	private String appGroupName;
	/**灰度服务[all:所有服务,none:不进行灰度,uaf-k3-provider,uaf-intellicredit-provider:指定服务]*/
	@Value("${eureka.instance.metadata-map.gray-server-name}")
	private String grayServerName;

	/**初始随机规则*/
	Random rand = new Random();

	@Override
	public void initWithNiwsConfig(IClientConfig iClientConfig) {

	}

	@Override
	public Server choose(Object o) {
		/**可用服务*/
		List<Server> upList = getLoadBalancer().getReachableServers();
		/**所有服务*/
		List<Server> allList = getLoadBalancer().getAllServers();
		/**服务数*/
		int serverCount = allList.size();
		if (serverCount == 0) {
			return null;
		}
		/**服务名称*/
		String serverName = ((DiscoveryEnabledServer) upList.get(0)).getInstanceInfo().getAppName();
		/**判定是否进入灰度流程*/
		if ("all".equalsIgnoreCase(grayServerName) && !appGroupName.equalsIgnoreCase("all")) {
			return grayStrategy(upList);
		} else if (grayServerName.toUpperCase().contains(serverName) && !appGroupName.equalsIgnoreCase("all")) {
			return grayStrategy(upList);
		} else {
			int index = this.rand.nextInt(serverCount);
			return upList.get(index);
		}
	}

	/**
	 * 灰度调用规则
	 * @param upList eureka可用服务列表
	 * @return com.netflix.loadbalancer.Server
	 * @author Eric
	 * @date 2019/9/19 10:55
	 */
	public Server grayStrategy(List<Server> upList) {
		for (Server server : upList) {
			/**服务分组*/
			String upAppGroupName = ((DiscoveryEnabledServer) server).getInstanceInfo().getMetadata().get("group-name");
			if (appGroupName.equals(upAppGroupName)) {
				MySlf4j.textInfo("进入灰度规则,服务地址:{0},集群组:{1}", server.getHost(), upAppGroupName);
				return server;
			}
		}
		return null;
	}

}
