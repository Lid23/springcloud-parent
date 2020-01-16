package com.noodles.gateway.utils;

import java.util.List;

import org.springframework.stereotype.Component;

import com.noodles.api.exception.MicroserviceException;
import com.noodles.api.exception.MicroserviceServiceException;
import com.noodles.api.vo.req.BaseReqVo;
import com.noodles.gateway.bean.MerchantLimitBean;

/**
 * @filename CreditUtils
 * @description 征信服务工具类
 * @author Eric
 * @date 2019/3/27 10:51
 */
@Component
public class MerchantUtils {

	/**
	 * 私有构造器
	 * @author Eric
	 * @date 2019/5/15 10:03
	 */
	private MerchantUtils() {
	}

	/**
	 * 校验商户限制信息
	 * @param baseReqVo 公共请求Vo
	 * @param rztMerchantLimitBeans 商户限制信息列表
	 * @author Eric
	 * @date 2019/4/4 17:51
	 */
	public static void checkMerchantLimit(BaseReqVo baseReqVo, List<MerchantLimitBean> rztMerchantLimitBeans) {
		boolean exists = false;
		boolean configed = false;
		/**判断IP是否在禁用列表*/
		for (MerchantLimitBean limit : rztMerchantLimitBeans) {
			if (GatewayConstantParamUtils.STATUS_ENABLE.equals(limit.getStatus())
					&& GatewayConstantParamUtils.LIMIT_ITEM_IP.equals(limit.getLimitItem().toUpperCase())
					&& GatewayConstantParamUtils.LIMIT_TYPE_FORBID.equals(limit.getLimitType()) && baseReqVo
					.getIp().equals(limit.getLimitValue())) {
				exists = true;
				break;
			}
		}
		if (exists) {
			throw new MicroserviceServiceException(MicroserviceException.ERR_100005);
		}

		/**判断IP是否在允许列表*/
		for (MerchantLimitBean limit : rztMerchantLimitBeans) {
			if (GatewayConstantParamUtils.STATUS_ENABLE.equals(limit.getStatus())
					&& GatewayConstantParamUtils.LIMIT_ITEM_IP.equals(limit.getLimitItem().toUpperCase())
					&& GatewayConstantParamUtils.LIMIT_TYPE_ALLOW.equals(limit.getLimitType())) {
				configed = true;
				if (baseReqVo.getIp().equals(limit.getLimitValue())) {
					exists = true;
					break;
				}
			}
		}
		if (configed && !exists) {
			throw new MicroserviceServiceException(MicroserviceException.ERR_100005);
		}
	}

}
