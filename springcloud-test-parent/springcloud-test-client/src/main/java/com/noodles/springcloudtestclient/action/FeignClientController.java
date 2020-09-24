package com.noodles.springcloudtestclient.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.noodles.api.vo.req.BaseReqVo;
import com.noodles.api.vo.resp.BaseRespVo;
import com.noodles.ip.utils.IpUtils;
import com.noodles.json.utils.JsonUtils;
import com.noodles.logback.MySlf4j;
import com.noodles.springcloudtestfeign.service.FeignService;

/**
 * @filename ConsumerController
 * @description consumerController
 * @author 巫威
 * @date 2020/1/16 15:21
 */
@RestController
public class FeignClientController {

	@Autowired
	FeignService feignService;

	/**
	 * 测试服务提供者post接口
	 * @param name
	 * @return com.noodles.api.vo.resp.BaseRespVo<java.lang.String>
	 * @author 巫威
	 * @date 2020/9/24 13:49
	 */
	@PostMapping(value = "/client/postPerson", produces = "application/json; charset=UTF-8")
	public BaseRespVo<String> postPerson(String name){
		BaseReqVo<String> baseReqVo = new BaseReqVo<>();
		baseReqVo.setMerchantId("CAS20180522150623");
		baseReqVo.setMerchantKey("95d64d617dff4720b5c77770ed95bd92");
		baseReqVo.setSourceSystem("cas");
		baseReqVo.setIp("127.0.0.1");
		baseReqVo.setData(name);
		MySlf4j.textInfo(JsonUtils.toJson(baseReqVo));
		return feignService.postPerson(baseReqVo);
	}

	@GetMapping(value = "/client/getPerson", produces = "application/json; charset=UTF-8")
	public BaseRespVo<String> getPerson(String name){
		BaseReqVo<String> baseReqVo = new BaseReqVo<>();
		baseReqVo.setMerchantId("CAS20180522150623");
		baseReqVo.setMerchantKey("95d64d617dff4720b5c77770ed95bd92");
		baseReqVo.setSourceSystem("cas");
		baseReqVo.setIp("127.0.0.1");
		baseReqVo.setData(name);
		MySlf4j.textInfo(JsonUtils.toJson(baseReqVo));
		return feignService.getPerson(baseReqVo);
	}

}
