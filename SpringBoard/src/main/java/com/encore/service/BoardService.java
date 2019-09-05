package com.encore.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.encore.domain.BoardVO;
import com.encore.domain.Criteria;

public interface BoardService {
	public int register(BoardVO board);//게시물 등록
	public BoardVO get(int bno);//특정게시물 읽기(로그인 없이) 
	public boolean modify(BoardVO board);//게시물 수정
	public boolean remove(int bno);//특정게시물 삭제
	public List<BoardVO> getList(Criteria cri);//게시물 목록 조회
	
	//추가
	public int getTotal(Criteria cri); //전체 레코드 수를 구하기 위한 것
	
}
