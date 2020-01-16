package com.noodles.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * 文件名：WebSecurityConfig.java
 * 描述：统一身份认证
 * 作者：Eric
 * 日期：2018年1月16日下午2:31:46
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) {
		String[] antPatterns = new String[] {
				/** 邦秒爬授权成功回调 */
				"/v1/prAuthCallBack",
				/** 邦报告详单生成状态回调 */
				"/v1/prReportStatusCallBack",
				/** 聚信立任务创建状态推送 */
				"/v1/taskCreateReceiver",
				/** 聚信立授权状态推送 */
				"/v1/authorizeResultReceiver",
				/** 聚信立采集状态推送 */
				"/v1/collectResultReceiver",
				/** 聚信立解析状态推送 */
				"/v1/resolveResultReceiver",
				/** 人脸识别,22.10 接受并保存face++推送的结果 */
				"/v1/faceLite/receiveLiteResult",
				/** 人脸识别,22.11 获取face++推送的结果返回到活体认证后网页URL */
				"/v1/faceLite/gainResultAndReturnUrl",
				/**二代征信解析*/
				"/v1/addCreditAnalysisInfo" };
		/**忽略auth认证URL*/
		web.ignoring().antMatchers(antPatterns);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/**表示所有的访问都必须进行认证处理后才可以正常进行*/
		http.httpBasic().and().authorizeRequests().anyRequest().fullyAuthenticated();
		/**所有的Rest服务一定要设置为无状态，以提升操作性能*/
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.csrf().disable();
	}

}
