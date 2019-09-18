package com.encore.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDAOImpl implements SampleDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertSample1(String username) {
		sqlSession.insert(username);
	}

	@Override
	public void insertSample2(String username) {
		sqlSession.insert(username);
	}
	
}
