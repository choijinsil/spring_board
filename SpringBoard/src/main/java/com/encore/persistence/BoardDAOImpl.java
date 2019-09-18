package com.encore.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.domain.BoardVO;
import com.encore.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(BoardVO vo) {
        sqlSession.insert("board.insert",vo);		
	}

	@Override
	//public List<BoardVO> selectAll(int page) {
	public List<BoardVO> selectAll(Criteria cri) {
		/*
		     현재페이지     skip 
		        1      0            (현재페이지-1) *10
		        2      10
		        3      20
		 */
		//RowBounds bounds = new RowBounds(30, 10); 
		//RowBounds bounds = new RowBounds((page-1)*10, 10); 
		RowBounds bounds = new RowBounds((cri.getPageNum()-1)*10, 10); 
		return sqlSession.selectList("board.selectAll",cri,   bounds);
		                              //  id           param   skip,limit
	}

	@Override
	public BoardVO select(int bno) {
		return sqlSession.selectOne("board.select", bno);
	}

	@Override
	public int selectBno() {
		return sqlSession.selectOne("board.selectBno");
	}

	@Override
	public int update(BoardVO board) {
		return sqlSession.update("board.update", board);
	}

	@Override
	public int delete(int bno) {
		return sqlSession.delete("board.delete", bno);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return sqlSession.selectOne("board.getTotalCount",cri);
	}

	@Override
	public void updateReplyCnt(int bno, int amount) {
		Map<String, Integer> map = new HashMap<>();
		   map.put("bno", bno);
		   map.put("amount", amount);
		
		sqlSession.update("board.updateReplyCnt", map );
	}

}







