package com.encore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encore.domain.Criteria;
import com.encore.domain.ReplyPageDTO;
import com.encore.domain.ReplyVO;
import com.encore.persistence.BoardDAO;
import com.encore.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO dao;

	@Autowired
	private BoardDAO boardDao;

	//댓글 등록
	@Transactional
	@Override
	public int register(ReplyVO vo) {
		boardDao.updateReplyCnt(vo.getBno(), 1); // 게시물번호, 1
		return dao.insert(vo);
	}

	@Transactional
	@Override
	public int modify(ReplyVO vo) {
		return dao.update(vo);
	}

	@Override
	public int remove(int rno) {
		// Reply테이블 삭제 --Board테이블 replycnt를 1감소

		ReplyVO vo = dao.find(rno); // 수정삭제 전 read하려고
		boardDao.updateReplyCnt(vo.getBno(), -1);
		return dao.delete(rno);
	}

	@Override
	public ReplyVO get(int rno) {
		return dao.find(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, int bno) {
		int count = dao.getCountByBno(bno); // 특정 게시물에 대한 전체 댓글 수
		List<ReplyVO> list = dao.getListWithPaging(cri, bno); // 특정페이지의 제한된(10개) 조회

		return new ReplyPageDTO(count, list);
	}

}
