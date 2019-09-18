package com.encore.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.encore.service.SampleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SampleServiceTest {

	@Autowired
	private SampleService service;

	@Test
	public void testAdd() throws Exception {
		System.out.println(service.doAdd("300", "600"));
	}

}
