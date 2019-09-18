package com.encore.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.encore.service.SampleTxService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class SampleTxServiceTest {
	
	@Autowired
	private SampleTxService service;

	@Test
	public void testUserNameInsert() {
		String username = "홍길동";
		service.addUsername(username);
		System.out.println("입력성공~");

	}

}
