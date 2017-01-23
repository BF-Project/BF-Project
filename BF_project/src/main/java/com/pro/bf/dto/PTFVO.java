package com.pro.bf.dto;

/**
 * @author 차승현<br>
 * 플렛폼(템플릿) 테이블
 */
public class PTFVO {

	private int ptf_num; // key, 일련번호
	private String ptf_nm; // 템플릿 이름
	private int ptf_dld_quty; // 템플릿 다운로드 횟수
	
	public int getPtf_num() {
		return ptf_num;
	}
	
	public void setPtf_num(int ptf_num) {
		this.ptf_num = ptf_num;
	}
	
	public String getPtf_nm() {
		return ptf_nm;
	}
	
	public void setPtf_nm(String ptf_nm) {
		this.ptf_nm = ptf_nm;
	}
	
	public int getPtf_dld_quty() {
		return ptf_dld_quty;
	}
	
	public void setPtf_dld_quty(int ptf_dld_quty) {
		this.ptf_dld_quty = ptf_dld_quty;
	}
}