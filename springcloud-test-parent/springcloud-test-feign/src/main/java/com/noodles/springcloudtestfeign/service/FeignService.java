package com.noodles.springcloudtestfeign.service;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
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
public interface FeignService {

	@PostMapping("/springcloudtestprovider/v1/hello")
	BaseRespVo<String> hello(@RequestBody @Valid BaseReqVo<String> baseReqVo);

}
