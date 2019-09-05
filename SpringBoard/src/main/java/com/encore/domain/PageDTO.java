package com.encore.domain;

public class PageDTO {
	// list.jsp페이지에서 출력되는 레코드의 정보[하단의 숫자출력, 현제페이지] 를 저장하는 용도
	private int startPage; // 시작페이지
	private int endPage; // 끝페이지
	private boolean prev, next; // list.jsp의 이전다음 버튼

	private int total; // 전체레코드 수 표현
	private Criteria cri; // 현재 페이지와 화면의 출력될 게시물 수를 표현

	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
		startPage = endPage - 9;

		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

		if (realEnd < this.endPage) {
			endPage = realEnd;
		}

		prev = startPage > 1;
		next = endPage < realEnd;
	}

}
