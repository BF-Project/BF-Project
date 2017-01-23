package com.pro.bf.dto;

/**
 * @author 차승현<br>
 * 숙박업 테이블
 */
public class MotelVO {

	private int mt_num; // key, 일련번호
	private String mt_nm; // 업소명
	private String mt_addr; // 주소
	
	public int getMt_num() {
		return mt_num;
	}
	
	public void setMt_num(int mt_num) {
		this.mt_num = mt_num;
	}
	
	public String getMt_nm() {
		return mt_nm;
	}
	
	public void setMt_nm(String mt_nm) {
		this.mt_nm = mt_nm;
	}
	
	public String getMt_addr() {
		return mt_addr;
	}
	
	public void setMt_addr(String mt_addr) {
		this.mt_addr = mt_addr;
	}
}