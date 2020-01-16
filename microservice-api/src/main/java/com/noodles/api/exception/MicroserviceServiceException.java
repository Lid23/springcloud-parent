package com.noodles.api.exception;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class MicroserviceServiceException extends RuntimeException {

	private static final long serialVersionUID = 852443720359797737L;

	/**错误信息集*/
	private static Map<String, String> errMsgMap = new HashMap<String, String>();

	/**错误代码*/
	private String code;

	static {
		errMsgMap.put(MicroserviceException.ERR_100000, "系统异常");
		errMsgMap.put(MicroserviceException.ERR_100001, "服务器运行时异常");
		errMsgMap.put(MicroserviceException.ERR_100002, "未获取到对应信息");
		errMsgMap.put(MicroserviceException.ERR_100003, "参数校验不通过");
		errMsgMap.put(MicroserviceException.ERR_100004, "商户不可用");
		errMsgMap.put(MicroserviceException.ERR_100005, "请求IP不可用或者被不被允许");
		errMsgMap.put(MicroserviceException.ERR_100006, "调用异常");
		errMsgMap.put(MicroserviceException.ERR_100007, "参数校验异常");
		errMsgMap.put(MicroserviceException.ERR_100008, "非法请求");
	}

	/**
	 * 征信服务自定义异常构造方法
	 * @param code 异常代码
	 * @author Eric
	 * @date 2019/4/17 13:42
	 */
	public MicroserviceServiceException(String code) {
		super(errMsgMap.get(code) == null ? ("未知代码:" + code) : errMsgMap.get(code));
		this.code = code;
	}

	/**
	 * 征信服务自定义异常构造方法
	 * @param code 异常代码
	 * @param message 异常信息
	 * @author Eric
	 * @date 2019/4/17 13:42
	 */
	public MicroserviceServiceException(String code, String message) {
		super(message);
		this.code = code;
	}

	/**
	 * 征信服务自定义异常构造方法
	 * @param code 异常代码
	 * @param args 变量
	 * @return
	 * @author Eric
	 * @date 2019/4/17 13:43
	 */
	public MicroserviceServiceException(String code, Object[] args) {
		super(errMsgMap.get(code) == null ? ("未知代码:" + code) : (MessageFormat.format(errMsgMap.get(code), args)));
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}