package com.noodles.springcloudtestfeign.service;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.noodles.api.vo.req.BaseReqVo;
import com.noodles.api.vo.resp.BaseRespVo;
import com.noodles.springcloudtestfeign.service.fallback.FeignFallBack;

/**
 * fegin调用接口
 * @filename FeignService
 * @author 巫威
 * @date 2019/8/12 17:03
 */
@FeignClient(value = "springcloud-gateway", fallback = FeignFallBack.class)
//@FeignClient(value = "springcloud-test-provider", fallback = FeignFallBack.class)
public interface FeignService {

	/**
	 * FeignClient首次请求花费大量时间导致首次请求失败，模拟第一次请求做feign client的真正初始化
	 * @return java.lang.String
	 * @author 巫威
	 * @date 2020/9/24 14:40
	 */
	@GetMapping("/testprovider/v1/heartbeat")
	String heartbeat();

	@PostMapping("/testprovider/v1/postPerson")
	BaseRespVo<String> postPerson(@RequestBody BaseReqVo<String> baseReqVo);

	@GetMapping("/testprovider/v1/getPerson")
	BaseRespVo<String> getPerson(@RequestBody BaseReqVo<String> baseReqVo);

}
