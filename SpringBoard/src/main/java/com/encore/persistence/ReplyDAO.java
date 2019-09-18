package com.encore.persistence;

import java.util.List;

import com.encore.domain.Criteria;
import com.encore.domain.ReplyVO;

public interface ReplyDAO {
	
	public int insert(ReplyVO vo);
	public int update(ReplyVO vo);
	public int delete(int rno);
	
	
	public ReplyVO find(int rno);
	public List<ReplyVO> findAll();
	public int getCountByBno(int bno);
	public List<ReplyVO> getListWithPaging(Criteria cri, int bno);

}




