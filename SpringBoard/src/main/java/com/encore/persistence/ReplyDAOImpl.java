package com.encore.persistence;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.domain.Criteria;
import com.encore.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(ReplyVO vo) {
		return sqlSession.insert("reply.insert", vo);
	}

	@Override
	public int update(ReplyVO vo) {
		return sqlSession.update("reply.update", vo);
	}

	@Override
	public int delete(int rno) {
		return sqlSession.delete("reply.delete", rno);
	}

	@Override
	public ReplyVO find(int rno) {
		return sqlSession.selectOne("reply.find", rno);
	}

	@Override
	public List<ReplyVO> findAll() {
		return null;
	}

	@Override
	public int getCountByBno(int bno) {
		return sqlSession.selectOne("reply.getCountByBno", bno);
	}

	@Override
	public List<ReplyVO> getListWithPaging(Criteria cri, int bno) {
		/*
		    1페이지의 skip  ---> 0
		    2페이지의 skip  ---> 10
		    3페이지의 skip  ---> 20
		 */	
		
		//RowBounds bounds = new RowBounds(int skip, int max);
		//RowBounds bounds = new RowBounds( (cri.getPageNum()-1)*10, cri.getAmount());
		RowBounds bounds = new RowBounds( (cri.getPageNum()-1)*cri.getAmount(), 
				                             cri.getAmount());
		
		return sqlSession.selectList("reply.getListWithPaging",bno,bounds);
	}

}



