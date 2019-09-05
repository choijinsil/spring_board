package com.encore.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.encore.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert(BoardVO vo) {
		sqlSession.insert("board.insert", vo);
	}

	@Override
	public List<BoardVO> selectAll() {
		return sqlSession.selectList("board.selectAll");
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
		return sqlSession.delete("board.delete",bno);
	}

}
