package com.pro.bf.dto;

import java.sql.Date;


public class CmmtCmtVO {

	private int cmmtcmt_num; //커뮤니티 게시판 댓글 번호
	private String cmmtcmt_content;//커뮤니티 게시판 댓글 내용
	private Date cmmtcmt_date;//커뮤니티 게시판 날짜
	private String admin_id;//관리자 아이디
	private int cmmt_num;//커뮤니티 게시판 일련번호
	private String mbr_id;//회원아이디
	
	public int getCmmtcmt_num() {
		return cmmtcmt_num;
	}
	public void setCmmtcmt_num(int cmmtcmt_num) {
		this.cmmtcmt_num = cmmtcmt_num;
	}
	public String getCmmtcmt_content() {
		return cmmtcmt_content;
	}
	public void setCmmtcmt_content(String cmmtcmt_content) {
		this.cmmtcmt_content = cmmtcmt_content;
	}
	public Date getCmmtcmt_date() {
		return cmmtcmt_date;
	}
	public void setCmmtcmt_date(Date cmmtcmt_date) {
		this.cmmtcmt_date = cmmtcmt_date;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public int getCmmt_num() {
		return cmmt_num;
	}
	public void setCmmt_num(int cmmt_num) {
		this.cmmt_num = cmmt_num;
	}
	public String getMbr_id() {
		return mbr_id;
	}
	public void setMbr_id(String mbr_id) {
		this.mbr_id = mbr_id;
	}
	
	
	
}
