package com.encore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.domain.BoardVO;
import com.encore.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO dao;
	
	@Override
	public int register(BoardVO board) {
		int bno=dao.selectBno();
		board.setBno(bno);
		dao.insert(board);
		return bno;
	}

	@Override
	public BoardVO get(int bno) {
		return dao.select(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		int upCnt=dao.update(board);
		if(upCnt>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(int bno) {
		int delCnt=dao.delete(bno);
		System.out.println("delCnt>>"+delCnt);
		if(delCnt==1) {
			return true;
		}
		return false;
	}

	@Override
	public List<BoardVO> getList() {
		
		return dao.selectAll();
	}

}
