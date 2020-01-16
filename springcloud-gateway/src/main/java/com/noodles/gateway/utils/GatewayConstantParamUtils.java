package com.noodles.gateway.utils;

/**
 * @filename GatewayConstantParamUtils
 * @description 网关常量类
 * @autor Eric
 * @date 2019/7/22 8:12
 */
public class GatewayConstantParamUtils {

	/**
	 * 私有构造器
	 * @author Eric
	 * @date 2019/7/22 8:12
	 */
	private GatewayConstantParamUtils() {
	}

	/**状态-启用*/
	public static final String STATUS_ENABLE = "1";

	/**状态-停用*/
	public static final String STATUS_DISABLE = "0";

	/**禁止*/
	public static final String LIMIT_TYPE_FORBID = "0";

	/**允许*/
	public static final String LIMIT_TYPE_ALLOW = "1";

	/**IP*/
	public static final String LIMIT_ITEM_IP = "IP";

}
