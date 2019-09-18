package com.encore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encore.persistence.SampleDAO;

@Service
public class SampleTxServiceImpl implements SampleTxService {

	@Autowired
	private SampleDAO dao;

	@Transactional
	@Override
	public void addUsername(String username) {
		// 전달받은 이름을
		dao.insertSample1(username);
		dao.insertSample2(username);
	}
}
