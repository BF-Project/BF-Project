package com.pro.bf.dto;

import java.sql.Date;

/**
 * @author 차승현<br>
 * 댓글 테이블
 */
public class CmtVO {

	private int cmt_num; // key, 댓글 일련번호
	private String cmt_content; // 댓글 내용
	private Date cmt_date; // 댓글생성날짜
	private String admin_id; // 관리자 아이디(FK)
	private int fre_num; // 자유게시판 일련번호(FK)
	private int cmmt_num; // 커뮤니티게시판 일련번호(FK)
	private String mbr_id; // 회원 아이디(FK)
	
	public int getCmt_num() {
		return cmt_num;
	}
	
	public void setCmt_num(int cmt_num) {
		this.cmt_num = cmt_num;
	}
	
	public String getCmt_content() {
		return cmt_content;
	}
	
	public void setCmt_content(String cmt_content) {
		this.cmt_content = cmt_content;
	}
	
	public Date getCmt_date() {
		return cmt_date;
	}
	
	public void setCmt_date(Date cmt_date) {
		this.cmt_date = cmt_date;
	}
	
	public String getAdmin_id() {
		return admin_id;
	}
	
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	
	public int getFre_num() {
		return fre_num;
	}
	
	public void setFre_num(int fre_num) {
		this.fre_num = fre_num;
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