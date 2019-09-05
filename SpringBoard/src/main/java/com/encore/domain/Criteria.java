package com.encore.domain;

public class Criteria {

	private int pageNum;// 현재 페이지 번호
	private int amount;// 브라우저 한화면에 보여질 레코드 수

	public Criteria() {
		pageNum = 1; //기본페이지
		amount = 10;
	}

	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
