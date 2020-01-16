package com.noodles.gateway.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noodles.api.exception.MicroserviceException;
import com.noodles.api.exception.MicroserviceServiceException;
import com.noodles.api.vo.req.BaseReqVo;
import com.noodles.api.vo.resp.BaseRespVo;
import com.noodles.common.constant.utils.GlobalConstantParamUtils;
import com.noodles.common.response.utils.ResponseUtils;
import com.noodles.gateway.bean.MerchantConfBean;
import com.noodles.gateway.bean.MerchantLimitBean;
import com.noodles.gateway.dao.IMerchantAuthDao;
import com.noodles.gateway.service.IMerchantAuthService;
import com.noodles.gateway.utils.GatewayConstantParamUtils;
import com.noodles.gateway.utils.MerchantUtils;

/**
 * @filename MerchantAuthReadServiceImpl
 * @description 商户身份认证实现
 * @autor Eric
 * @date 2019/4/25 12:07
 */
@Service
public class MerchantAuthServiceImpl implements IMerchantAuthService {

	/** 商户身份认证Dao */
	@Autowired
	private IMerchantAuthDao merchantAuthDao;

	@Override
	public <T> BaseRespVo<T> checkMerchantAuth(BaseReqVo<T> baseReqVo) throws Exception {
		/**1.校验商户配置*/
		MerchantConfBean yrzMerchantConfBean = new MerchantConfBean();
		yrzMerchantConfBean.setMerchantId(baseReqVo.getMerchantId());
		yrzMerchantConfBean.setMerchantKey(baseReqVo.getMerchantKey());
		yrzMerchantConfBean.setStatus(GatewayConstantParamUtils.STATUS_ENABLE);
		MerchantConfBean merchantConfBean = merchantAuthDao.queryMerchantConf(yrzMerchantConfBean);
		if (null == merchantConfBean) {
			throw new MicroserviceServiceException(MicroserviceException.ERR_100004);
		}
		/**2.校验商户限制*/
		List<MerchantLimitBean> rztMerchantLimitBeans = merchantAuthDao.queryMerchantLimits(baseReqVo.getMerchantId());
		if (null != rztMerchantLimitBeans) {
			MerchantUtils.checkMerchantLimit(baseReqVo, rztMerchantLimitBeans);
		}
		return ResponseUtils.responseMsg(GlobalConstantParamUtils.RESULT_CODE_SUCC, "商户校验通过", null);
	}

}
