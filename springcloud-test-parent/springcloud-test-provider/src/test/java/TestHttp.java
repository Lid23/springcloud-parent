import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.druid.util.Base64;
import com.noodles.api.vo.req.BaseReqVo;
import com.noodles.common.http.utils.HttpClientUtils;
import com.noodles.common.ip.utils.IpUtils;
import com.noodles.common.json.utils.JsonUtils;
import com.noodles.log.MySlf4j;

public class TestHttp {

	@Test
	public void testGatewayAction() {

		//String url = "http://10.168.96.41:8801/springcloudtestprovider/hello";
		//网关地址
		String url = "http://10.168.96.41:8201/springcloudtestprovider/v1/hello";
		BaseReqVo<String> baseReqVo = new BaseReqVo<>();
		baseReqVo.setMerchantId("CAS20180522150623");
		baseReqVo.setMerchantKey("95d64d617dff4720b5c77770ed95bd92");
		baseReqVo.setSourceSystem("cas");
		baseReqVo.setIp(IpUtils.getServerIpAddr());
		baseReqVo.setData("Eric");
		MySlf4j.textInfo(JsonUtils.toJson(baseReqVo));

		/**security授权*/
		/*Map<String, String> header = new HashMap<>();
		String userPass = "yrzcredit".concat(":").concat("yrzcredit");
		String authorization = "Basic".concat(" ").concat(Base64.byteArrayToBase64(userPass.getBytes()));
		header.put("Authorization", authorization);
		header.put("Content-Type", "application/json");
		String response = HttpClientUtils.doPost(url, JsonUtils.toJson(baseReqVo), header);*/
		String response = HttpClientUtils.doPost(url, JsonUtils.toJson(baseReqVo));
		MySlf4j.textInfo(response);
	}


}
