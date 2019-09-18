package com.encore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.domain.BoardVO;
import com.encore.domain.Criteria;
import com.encore.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO dao;
	
	@Override
	public int register(BoardVO board) {
		 int bno = dao.selectBno();
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
		int upCnt = dao.update(board);
		if(upCnt==1)return true;
		return false;
	}

	@Override
	public boolean remove(int bno) {
		
		if(dao.delete(bno)==1) return true;		
		return false;
	}

	/*
	 * @Override public List<BoardVO> getList(int page) { return
	 * dao.selectAll(page); }
	 */
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		return dao.selectAll(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return dao.getTotalCount(cri);
	}

}






