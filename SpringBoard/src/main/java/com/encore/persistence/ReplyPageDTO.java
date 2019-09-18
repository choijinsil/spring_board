package com.encore.persistence;

import java.util.List;

import com.encore.domain.ReplyVO;

public class ReplyPageDTO {// DTO: 계층간 전달할 데이터를 표현
	private int replyCnt; // 댓글의 수
	private List<ReplyVO> list;

	public int getReplyCnt() {
		return replyCnt;
	}

	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}

	public List<ReplyVO> getList() {
		return list;
	}

	public void setList(List<ReplyVO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ReplyPageDTO [replyCnt=" + replyCnt + ", list=" + list + "]";
	}

	public ReplyPageDTO(int replyCnt, List<ReplyVO> list) {
		super();
		this.replyCnt = replyCnt;
		this.list = list;
	}

	public ReplyPageDTO() {
		// TODO Auto-generated constructor stub
	}

}
