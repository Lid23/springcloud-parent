/*
package com.noodles.gateway.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;
import com.noodles.log.MySlf4j;

@Configuration
public class DataSourceSecurityConfig {

	*/
/** 驱动 *//*

	@Value("${spring.datasource.driver-class-name}")
	private String driver;
	*/
/** 链接 *//*

	@Value("${spring.datasource.url}")
	private String url;
	*/
/** 用户名 *//*

	@Value("${spring.datasource.username}")
	private String username;
	*/
/** 密码 *//*

	@Value("${spring.datasource.password}")
	private String password;
	*/
/** 数据源连接验证 *//*

	@Value("${spring.datasource.validation-query}")
	private String validationQuery;
	*/
/** 初始化提供的连接数 *//*

	@Value("${spring.datasource.initial-size}")
	private int initialSize;
	*/
/** 等待连接获取的最大超时时间(毫秒) *//*

	@Value("${spring.datasource.max-wait}")
	private long maxWait;
	*/
/** 数据库连接池的最小维持连接数 *//*

	@Value("${spring.datasource.min-idle}")
	private int minIdle;
	*/
/** 最大的连接数 *//*

	@Value("${spring.datasource.max-active}")
	private int maxActive;
	*/
/** 假如一个对象验证失败，则对象将被从池中释放 *//*

	@Value("${spring.datasource.test-while-idle}")
	private Boolean testWhileIdle;
	*/
/** 确认连接有效SQL的执行查询超时时间（秒） *//*

	@Value("${spring.datasource.validation-query-timeout}")
	private int validationQueryTimeout;
	*/
/** 公钥 *//*

	@Value("${spring.datasource.public-key}")
	private String publicKey;
	*/
/** 配置ConfigFilter解密密码 *//*

	@Value("${spring.datasource.connectionProperties}")
	private String connectionProperties;
	*/
/** 过滤器 *//*

	@Value("${spring.datasource.filters}")
	private String filters;
	*/
/** 数据源对象 *//*

	private DruidDataSource druidDataSource = new DruidDataSource();

	@Bean("dataSource")
	public DataSource druidDataSource() throws Exception {

		try {
			druidDataSource.setDriverClassName(driver);
			druidDataSource.setUrl(url);
			String user = ConfigTools.decrypt(publicKey, username);
			druidDataSource.setUsername(user);
			druidDataSource.setPassword(password);
			druidDataSource.setValidationQuery(validationQuery);
			druidDataSource.setInitialSize(initialSize);
			druidDataSource.setMaxWait(maxWait);
			druidDataSource.setMinIdle(minIdle);
			druidDataSource.setMaxActive(maxActive);
			druidDataSource.setValidationQueryTimeout(validationQueryTimeout);
			druidDataSource.setTestWhileIdle(testWhileIdle);
			druidDataSource.setConnectionProperties(connectionProperties.replace("${public-key}", publicKey));
			druidDataSource.setFilters(filters);
			return druidDataSource;
		} catch (Exception e) {
			MySlf4j.textError("创建Druid数据源异常:{0}", MySlf4j.ExceptionToString(e));
			throw new RuntimeException(e);
		}
	}
}
*/
