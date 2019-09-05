package com.encore.test;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//spring밑의 어떤 폴더도 상관없다 -->**
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DataSourceTest {
	
	@Inject //inject와 @Autowired를 사용한다.
	//@Autowired
	private DataSource ds;//할당된 메모리 없음
	@Test
	public void testConnection() throws Exception{
		Connection conn= ds.getConnection();
		System.out.println("DBCP 연결성공!"); 
	}

}
