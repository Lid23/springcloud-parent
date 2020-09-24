package com.noodles.springcloudtestprovider.springcloudfeign;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noodles.api.vo.req.BaseReqVo;
import com.noodles.api.vo.resp.BaseRespVo;
import com.noodles.json.utils.JsonUtils;
import com.noodles.logback.MySlf4j;
import com.noodles.response.utils.ResponseUtils;

/**
 * @filename FeignProviderAction
 * @description helloworld测试
 * @author 巫威
 * @date 2020/1/16 9:22
 */
@RestController
@RequestMapping("/v1")
public class FeignProviderAction {

	@PostMapping("/postPerson")
	BaseRespVo<String> hello(@RequestBody @Valid BaseReqVo<String> baseReqVo){
		MySlf4j.textInfo("请求消息:{0}", JsonUtils.toJson(baseReqVo));
		return ResponseUtils.responseSuccess("hello," + baseReqVo.getData());
	}

	@GetMapping("/getPerson")
	BaseRespVo<String> getPerson(@RequestBody @Valid BaseReqVo<String> baseReqVo){
		MySlf4j.textInfo("请求消息:{0}", JsonUtils.toJson(baseReqVo));
		return ResponseUtils.responseSuccess("hello," + baseReqVo.getData());
	}
}
