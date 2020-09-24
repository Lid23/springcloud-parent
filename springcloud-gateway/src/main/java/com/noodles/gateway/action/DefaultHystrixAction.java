package com.noodles.gateway.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.noodles.api.exception.MicroserviceException;
import com.noodles.api.vo.resp.BaseRespVo;
import com.noodles.logback.MySlf4j;
import com.noodles.response.utils.ResponseUtils;

/**
 * @filename DefaultHystrixController
 * @description 网关熔断Action
 * @author Eric
 * @date 2019/4/12 11:26
 */
@RestController
public class DefaultHystrixAction {

	/**
	 * gateway网关熔断处理
	 * @return java.lang.String
	 * @author Eric
	 * @date 2019/4/12 11:30
	 */
	@RequestMapping(value = "/defaultfallback", method = RequestMethod.GET)
	public BaseRespVo<Object> defaultfallback() {
		MySlf4j.textInfo("【microservice-gateway】网关触发熔断......");
		return ResponseUtils.responseMsg(MicroserviceException.ERR_100001, "服务不可用", null);
	}
}
