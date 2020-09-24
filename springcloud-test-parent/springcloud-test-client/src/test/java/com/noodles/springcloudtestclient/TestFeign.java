package com.noodles.springcloudtestclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.noodles.api.vo.req.BaseReqVo;
import com.noodles.ip.utils.IpUtils;
import com.noodles.json.utils.JsonUtils;
import com.noodles.logback.MySlf4j;
import com.noodles.springcloudtestfeign.service.FeignService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringcloudTestClientApplication.class)
public class TestFeign {

	@Autowired
	FeignService feignService;

	@Test
	public void helloConsumer(){

	}

}
