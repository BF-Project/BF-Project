package com.pro.bf.dto;

import java.util.Date;


/**
 * @author 차승현<br>
 * 회원 테이블
 */
public class MbrVO {

	private String mbr_id; // key, 회원아이디
	private String mbr_pwd; // 패스워드
	private String mbr_nm; // 이름
	private String mbr_eml; // 이메일
	private String mbr_phone; // 전화번호
	private String mbr_addr; // 주소
	private Date mbr_brt; // 생년월일
	private String mbr_gnd; // 성별
	private Date mbr_date; // 아이디 생성날짜
	private String mbr_eml_yn; // 이메일 수신 여부 (default 'Y')
	private String use_yn; // 사용여부(default:Y)
	
	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public String getMbr_eml_yn() {
		return mbr_eml_yn;
	}

	public void setMbr_eml_yn(String mbr_eml_yn) {
		this.mbr_eml_yn = mbr_eml_yn;
	}

	public String getMbr_id() {
		return mbr_id;
	}
	
	public void setMbr_id(String mbr_id) {
		this.mbr_id = mbr_id;
	}
	
	public String getMbr_pwd() {
		return mbr_pwd;
	}
	
	public void setMbr_pwd(String mbr_pwd) {
		this.mbr_pwd = mbr_pwd;
	}
	
	public String getMbr_nm() {
		return mbr_nm;
	}
	
	public void setMbr_nm(String mbr_nm) {
		this.mbr_nm = mbr_nm;
	}
	
	public String getMbr_eml() {
		return mbr_eml;
	}
	
	public void setMbr_eml(String mbr_eml) {
		this.mbr_eml = mbr_eml;
	}
	
	public String getMbr_phone() {
		return mbr_phone;
	}
	
	public void setMbr_phone(String mbr_phone) {
		this.mbr_phone = mbr_phone;
	}
	
	public String getMbr_addr() {
		return mbr_addr;
	}
	
	public void setMbr_addr(String mbr_addr) {
		this.mbr_addr = mbr_addr;
	}
	
	public Date getMbr_brt() {
		return mbr_brt;
	}
	
	public void setMbr_brt(Date mbr_brt) {
		this.mbr_brt = mbr_brt;
	}
	
	public String getMbr_gnd() {
		return mbr_gnd;
	}
	
	public void setMbr_gnd(String mbr_gnd) {
		this.mbr_gnd = mbr_gnd;
	}
	
	public Date getMbr_date() {
		return mbr_date;
	}
	
	public void setMbr_date(Date mbr_date) {
		this.mbr_date = mbr_date;
	}
}