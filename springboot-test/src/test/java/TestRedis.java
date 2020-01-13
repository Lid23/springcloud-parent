import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.noodles.redis.v1.config.RedissonClientTemplate;
import com.noodles.springboottest.SpringbootTestApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootTestApplication.class)
public class TestRedis {

	@Autowired
	private RedissonClientTemplate redissonClientTemplate;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;


	@org.junit.Test
	public void testRedis() {
		int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
		System.out.println(stock);
	}


}
