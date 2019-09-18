package com.encore.service;

import java.util.List;

import com.encore.domain.Criteria;
import com.encore.domain.ReplyPageDTO;
import com.encore.domain.ReplyVO;

public interface ReplyService {
   public int register(ReplyVO vo);
   public int modify(ReplyVO vo);
   public int remove(int rno);
   
   public ReplyVO get(int rno);
   public List<ReplyVO> getList(Criteria cri, int bno);
   
   public ReplyPageDTO getListPage(Criteria cri, int bno);
}




