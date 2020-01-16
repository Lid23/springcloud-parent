package com.noodles.gateway.service;

import com.noodles.api.vo.req.BaseReqVo;
import com.noodles.api.vo.resp.BaseRespVo;

/**
 * @filename IMerchantIdentityAuthService
 * @description 商户身份认证
 * @autor Eric
 * @date 2019/4/25 11:08
 */
public interface IMerchantAuthService {

	/**
	 * 功能描述
	 * @param baseReqVo 公共请求Vo
	 * @return com.noodles.api.vo.resp.BaseRespVo<?> 公共响应Vo
	 * @author Eric
	 * @exception
	 * @date 2019/4/25 12:07
	 */
	<T> BaseRespVo<T> checkMerchantAuth(BaseReqVo<T> baseReqVo) throws Exception;
}
