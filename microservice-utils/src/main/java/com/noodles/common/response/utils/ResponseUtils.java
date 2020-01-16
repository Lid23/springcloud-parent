package com.noodles.common.response.utils;

import com.noodles.api.exception.MicroserviceException;
import com.noodles.api.vo.resp.BaseRespVo;
import com.noodles.common.constant.utils.GlobalConstantParamUtils;

/**
 * @filename ResponseUtils
 * @description 统一请求返回类
 * @author Eric
 * @date 2019/3/26 16:51
 */
public class ResponseUtils {

	/**
	 * 私有构造器
	 * @author Eric
	 * @date 2019/5/15 10:03
	 */
	private ResponseUtils() {
	}

	/**
	 * 封装返回数据
	 * @param data 返回数据
	 * @return com.noodles.api.vo.resp.BaseRespVo<T>
	 * @author Eric
	 * @date 2019/3/27 11:08
	 */
	public static <T> BaseRespVo<T> responseSuccess(T data) {
		BaseRespVo<T> baseRespVo = new BaseRespVo<T>();
		baseRespVo.setCode(GlobalConstantParamUtils.RESULT_CODE_SUCC);
		baseRespVo.setMessage(GlobalConstantParamUtils.RESULT_MSG_SUCC);
		baseRespVo.setData(data);
		return baseRespVo;
	}

	/**
	 * 封装返回数据
	 * @param code 返回码
	 * @param message 返回信息
	 * @param data 返回数据
	 * @return com.noodles.api.vo.resp.BaseRespVo<T>
	 * @author Eric
	 * @exception
	 * @date 2019/3/27 11:08
	 */
	public static <T> BaseRespVo<T> responseMsg(String code, String message, T data) {
		BaseRespVo<T> baseRespVo = new BaseRespVo<T>();
		baseRespVo.setCode(code);
		baseRespVo.setMessage(message);
		baseRespVo.setData(data);
		return baseRespVo;
	}

	/**
	 * 封装返回数据
	 * @param data 返回数据
	 * @return com.noodles.api.vo.resp.BaseRespVo<T>
	 * @author Eric
	 * @exception
	 * @date 2019/3/27 11:08
	 */
	public static <T> BaseRespVo<T> responseFeignHystrix(T data) {
		BaseRespVo<T> baseRespVo = new BaseRespVo<T>();
		baseRespVo.setCode(MicroserviceException.ERR_100001);
		baseRespVo.setMessage("服务不可用");
		baseRespVo.setData(data);
		return baseRespVo;
	}

}
