package com.encore.service;

import java.util.List;

import com.encore.domain.BoardVO;
import com.encore.domain.Criteria;

public interface BoardService {
    public int register(BoardVO board);//게시물 등록
    public BoardVO get(int bno);//특정게시물 읽기(로그인 없이)
    public boolean modify(BoardVO board);//게시물 수정
    public boolean remove(int bno);//특정게시물 삭제
    //public List<BoardVO> getList(int page);//게시물 목록 조회
    public List<BoardVO> getList(Criteria cri);//게시물 목록 조회(키워드 조건에 일치)
    
    //추가
    //public int getTotal();//board전체 레코드 수
    public int getTotal(Criteria cri);//board전체 레코드 수(키워드 조건에 일치)    
}
