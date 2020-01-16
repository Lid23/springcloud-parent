package com.noodles.gateway.dao;

import java.util.List;

import com.noodles.gateway.bean.MerchantConfBean;
import com.noodles.gateway.bean.MerchantLimitBean;

/**
 * @filename IMerchantAuthDao
 * @description 商户身份认证
 * @autor Eric
 * @date 2019/4/25 12:08
 */
public interface IMerchantAuthDao {

	/**
	 * 获取认证通商户配置信息
	 * @param rztMerchantConfBean 认证通商户配置
	 * @return com.uaf.credit.api.bean.RztMerchantConfBean
	 * @author Eric
	 * @date 2019/4/4 10:09
	 */
	MerchantConfBean queryMerchantConf(MerchantConfBean rztMerchantConfBean) throws Exception;

	/**
	 * 获取认证通商户限制信息
	 * @param merchantId 商户ID
	 * @return java.util.List<com.uaf.credit.api.bean.RztMerchantLimitBean>
	 * @author Eric
	 * @date 2019/4/4 17:46
	 */
	List<MerchantLimitBean> queryMerchantLimits(String merchantId) throws Exception;
}
