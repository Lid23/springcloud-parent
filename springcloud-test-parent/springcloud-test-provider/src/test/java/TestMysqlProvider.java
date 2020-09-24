import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.noodles.json.utils.JsonUtils;
import com.noodles.logback.MySlf4j;
import com.noodles.springcloudtestprovider.SpringcloudTestProviderApplication;
import com.noodles.springcloudtestprovider.springbootmybatis.bean.DepartMents;
import com.noodles.springcloudtestprovider.springbootmybatis.dao.IDeptMentsDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringcloudTestProviderApplication.class)
public class TestMysqlProvider {

	@Autowired
	private IDeptMentsDao deptMentsDao;


	@Test
	public void testOracleProvider() {
		DepartMents departMentsParam = new DepartMents();
		departMentsParam.setDeptNo("d009");

		DepartMents departMents = deptMentsDao.selectOne(departMentsParam);
		MySlf4j.textInfo("返回结果：{0}", JsonUtils.toJson(departMents));
	}

}
