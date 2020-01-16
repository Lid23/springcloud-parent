package com.noodles.springcloudtestclient.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noodles.api.vo.req.BaseReqVo;
import com.noodles.api.vo.resp.BaseRespVo;
import com.noodles.common.ip.utils.IpUtils;
import com.noodles.common.json.utils.JsonUtils;
import com.noodles.log.MySlf4j;
import com.noodles.springcloudtestfeign.service.FeignService;

/**
 * @filename ConsumerController
 * @description consumerController
 * @author 巫威
 * @date 2020/1/16 15:21
 */
@RestController
public class ConsumerController {

	@Autowired
	FeignService feignService;

	@RequestMapping("/consumer")
	public BaseRespVo<String> helloConsumer(){
		BaseReqVo<String> baseReqVo = new BaseReqVo<>();
		baseReqVo.setMerchantId("CAS20180522150623");
		baseReqVo.setMerchantKey("95d64d617dff4720b5c77770ed95bd92");
		baseReqVo.setSourceSystem("cas");
		baseReqVo.setIp(IpUtils.getServerIpAddr());
		baseReqVo.setData("Eric");
		MySlf4j.textInfo(JsonUtils.toJson(baseReqVo));
		return feignService.hello(baseReqVo);
	}

}
