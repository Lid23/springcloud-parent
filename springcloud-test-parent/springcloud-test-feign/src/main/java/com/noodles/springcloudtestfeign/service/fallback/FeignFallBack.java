package com.noodles.springcloudtestfeign.service.fallback;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.noodles.api.vo.req.BaseReqVo;
import com.noodles.api.vo.resp.BaseRespVo;
import com.noodles.common.response.utils.ResponseUtils;
import com.noodles.springcloudtestfeign.service.FeignService;

/**
 * fegin调用实现
 * @filename FeignFallBack
 * @author 巫威
 * @date 2019/8/12 17:03
 */
@Component
public class FeignFallBack implements FeignService {

	@Override
	public BaseRespVo<String> hello(@Valid BaseReqVo<String> baseReqVo) {
		return ResponseUtils.responseFeignHystrix(null);
	}

}
