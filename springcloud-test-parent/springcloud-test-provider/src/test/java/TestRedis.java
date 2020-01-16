import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.noodles.api.vo.req.BaseReqVo;
import com.noodles.common.ip.utils.IpUtils;
import com.noodles.common.json.utils.JsonUtils;
import com.noodles.log.MySlf4j;
import com.noodles.redis.v1.config.RedissonClientTemplate;
import com.noodles.springcloudtestprovider.SpringcloudTestProviderApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringcloudTestProviderApplication.class)
public class TestRedis {

	@Autowired
	private RedissonClientTemplate redissonClientTemplate;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;


	@org.junit.Test
	public void testSetRedis() {
		//int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
		BaseReqVo<String> baseReqVo = new BaseReqVo<>();
		baseReqVo.setMerchantId("CAS20180522150623");
		baseReqVo.setMerchantKey("95d64d617dff4720b5c77770ed95bd92");
		baseReqVo.setSourceSystem("cas");
		baseReqVo.setIp(IpUtils.getServerIpAddr());
		baseReqVo.setData("Eric");
		//MySlf4j.textInfo(JsonUtils.toJson(baseReqVo));
		stringRedisTemplate.opsForValue().set("microservice:gateway:bf5b33aa-a8f3-4a3c-b0bc-c56b7b8d0cf3", JsonUtils.toJson(baseReqVo), 180, TimeUnit.SECONDS);

	}

	@org.junit.Test
	public void testRedis() {
		//int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));

		String str = stringRedisTemplate.opsForValue().get("microservice:gateway:bf5b33aa-a8f3-4a3c-b0bc-c56b7b8d0cf2");

		System.out.println(str);
	}


}
