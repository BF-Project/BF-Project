package com.pro.bf.dto;

import java.sql.Date;

/**
 * @author 차승현<br>
 * 관리자 테이블
 */
public class AdminVO {

	private String admin_id; // key, 관리자 아이디
	private String admin_pwd; // 관리자 비밀번호
	private String admin_nm; // 관리자 이름
	private String admin_phone; // 관리자 번호
	private Date admin_date; // 관리자 아이디 생성날짜 (sysdate)
	
	public String getAdmin_id() {
		return admin_id;
	}
	
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	
	public String getAdmin_pwd() {
		return admin_pwd;
	}
	
	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}
	
	public String getAdmin_nm() {
		return admin_nm;
	}
	
	public void setAdmin_nm(String admin_nm) {
		this.admin_nm = admin_nm;
	}
	
	public String getAdmin_phone() {
		return admin_phone;
	}
	
	public void setAdmin_phone(String admin_phone) {
		this.admin_phone = admin_phone;
	}
	
	public Date getAdmin_date() {
		return admin_date;
	}
	
	public void setAdmin_date(Date admin_date) {
		this.admin_date = admin_date;
	}
}