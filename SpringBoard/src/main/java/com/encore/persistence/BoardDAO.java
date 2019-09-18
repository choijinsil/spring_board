package com.encore.persistence;

import java.util.List;

import com.encore.domain.BoardVO;
import com.encore.domain.Criteria;

public interface BoardDAO {
     public void insert(BoardVO vo);
     //public List<BoardVO> selectAll(int page);
     public List<BoardVO> selectAll(Criteria cri);
     public BoardVO select(int bno);
     public int selectBno();
	 public int update(BoardVO board);
	 public int delete(int bno);
	 //public int getTotalCount();
	 public int getTotalCount(Criteria cri);
	 
	 public void updateReplyCnt(int bno, int amount);
}





