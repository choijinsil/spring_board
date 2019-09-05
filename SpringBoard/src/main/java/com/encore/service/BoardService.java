package com.encore.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.encore.domain.BoardVO;

public interface BoardService {
	public int register(BoardVO board);//게시물 등록
	public BoardVO get(int bno);//특정게시물 읽기(로그인 없이) 
	public boolean modify(BoardVO board);//게시물 수정
	public boolean remove(int bno);//특정게시물 삭제
	public List<BoardVO> getList();//게시물 목록 조회
}
