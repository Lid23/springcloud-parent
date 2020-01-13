import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.noodles.springboottest.SpringbootTestApplication;
import com.noodles.springboottest.springbootmybatis.bean.BaihangCreditMerConfigBean;
import com.noodles.springboottest.springbootmybatis.dao.IBaihangMerConfigDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootTestApplication.class)
public class TestOracleProvider {

	@Autowired
	private IBaihangMerConfigDao baihangMerConfigDao;


	@Test
	public void testOracleProvider() {
		BaihangCreditMerConfigBean baihangCreditMerConfigBean = new BaihangCreditMerConfigBean();
		baihangCreditMerConfigBean.setMerNo("201811201629150001");

		BaihangCreditMerConfigBean baihangCreditMerConfigBean1 = baihangMerConfigDao.selectOne(baihangCreditMerConfigBean);
		System.out.println(baihangCreditMerConfigBean1.getMerInfo());
	}



}
