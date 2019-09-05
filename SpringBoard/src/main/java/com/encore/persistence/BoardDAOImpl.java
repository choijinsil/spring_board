package com.encore.persistence;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.encore.domain.BoardVO;
import com.encore.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert(BoardVO vo) {
		sqlSession.insert("board.insert", vo);
	}

	@Override
	public List<BoardVO> selectAll(Criteria cri) {
		
		RowBounds bounds = new RowBounds((cri.getPageNum()-1)*10,10);
		return sqlSession.selectList("board.selectAll",cri,bounds);//id, param, bounds(skip, limit)
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

}
