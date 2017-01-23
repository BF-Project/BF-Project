package com.pro.bf.dto;

/**
 * @author 차승현<br>
 * 플렛폼(템플릿) 다운로드 테이블
 */
public class PTF_DldVO {

	private int ptf_dld_num; // key, 다운로드 번호(일련번호)
	private int ptf_num; // 플렛폼(템플릿) 일련번호(FK)
	private String mbr_id; // 회원아이디(다운로드한 회원)(FK)
	
	public int getPtf_dld_num() {
		return ptf_dld_num;
	}
	
	public void setPtf_dld_num(int ptf_dld_num) {
		this.ptf_dld_num = ptf_dld_num;
	}
	
	public int getPtf_num() {
		return ptf_num;
	}
	
	public void setPtf_num(int ptf_num) {
		this.ptf_num = ptf_num;
	}
	
	public String getMbr_id() {
		return mbr_id;
	}
	
	public void setMbr_id(String mbr_id) {
		this.mbr_id = mbr_id;
	}
}