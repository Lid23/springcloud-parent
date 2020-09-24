import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.Charsets;
import org.junit.Test;

import bean.C1ReportApplyInfoReqVo;
import com.noodles.api.vo.req.BaseReqVo;
import com.noodles.http.WebClientService;
import com.noodles.http.config.WebClientProperties;
import com.noodles.ip.utils.IpUtils;
import com.noodles.json.utils.JsonUtils;
import com.noodles.logback.MySlf4j;
import com.noodles.random.utils.RandomUtils;

public class TestHttp {

	public static WebClientService webClientService;

	private WebClientService getWebClientService() {
		if (webClientService != null) {
			return webClientService;
		}
		WebClientProperties properties = new WebClientProperties();
		properties.setConnectTimeout(3000);
		properties.setConnectTimeout(3000);
		webClientService = new WebClientService(properties);
		return webClientService;
	}

	@Test
	public void testGatewayAction() throws Exception {

		WebClientService webClientService = getWebClientService();

		/**网关地址*/
		String url = "http://10.168.96.41:8201/baihangcredit/v1/c1ReportApplyInfo";
		BaseReqVo<List<C1ReportApplyInfoReqVo>> baseReqVo = new BaseReqVo<>();
		baseReqVo.setMerchantId("CAS20180522150623");
		baseReqVo.setMerchantKey("95d64d617dff4720b5c77770ed95bd92");
		baseReqVo.setSourceSystem("cas");
		baseReqVo.setIp(IpUtils.getServerIpAddr());

		String c1Path = "E:/桌面工作/23-百行征信/2-开发/测试文件/C1.txt";
		List<String> c1ReportApplyInfoList = Files.readAllLines(Paths.get(c1Path), Charsets.UTF_8);
		List<C1ReportApplyInfoReqVo> c1ReportApplyInfoReqVoList = new ArrayList<C1ReportApplyInfoReqVo>();
		for (String c1ReportApplyInfoStr : c1ReportApplyInfoList) {
			C1ReportApplyInfoReqVo c1ReportApplyInfoReqVo = JsonUtils
					.fromJson(c1ReportApplyInfoStr, C1ReportApplyInfoReqVo.class);
			c1ReportApplyInfoReqVo.setMerNo("201812042125360000");
			c1ReportApplyInfoReqVo.setBusinessId(RandomUtils.getUuid());
			c1ReportApplyInfoReqVoList.add(c1ReportApplyInfoReqVo);
		}
		baseReqVo.setData(c1ReportApplyInfoReqVoList);

		MySlf4j.textInfo(JsonUtils.toJson(baseReqVo));
		String response = webClientService.postJson(url, baseReqVo);
		MySlf4j.textInfo(JsonUtils.toJson(response));
	}

}
