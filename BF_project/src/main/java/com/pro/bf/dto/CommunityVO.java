package com.pro.bf.dto;

import java.sql.Date;

/**
 * @author 차승현<br>
 * 커뮤니티 게시판 테이블
 */
public class CommunityVO {

	private int cmmt_num; // key, 커뮤니티 게시판 게시글 번호
	private String cmmt_title; // 게시판 제목
	private String cmmt_content; // 게시판 내용
	private int cmmt_cnt; // 게시판 조회수
	private Date cmmt_date; // 게시판 게시날짜(sysdate)
	private String cmmt_pict_afat; // 사진첨부(파일이름)
	private String admin_id; // 관리자 아이디(FK)
	private String mbr_id; // 회원 아이디(FK)
	
	public int getCmmt_num() {
		return cmmt_num;
	}
	
	public void setCmmt_num(int cmmt_num) {
		this.cmmt_num = cmmt_num;
	}
	
	public String getCmmt_title() {
		return cmmt_title;
	}
	
	public void setCmmt_title(String cmmt_title) {
		this.cmmt_title = cmmt_title;
	}
	
	public String getCmmt_content() {
		return cmmt_content;
	}
	
	public void setCmmt_content(String cmmt_content) {
		this.cmmt_content = cmmt_content;
	}
	
	public int getCmmt_cnt() {
		return cmmt_cnt;
	}
	
	public void setCmmt_cnt(int cmmt_cnt) {
		this.cmmt_cnt = cmmt_cnt;
	}
	
	public Date getCmmt_date() {
		return cmmt_date;
	}
	
	public void setCmmt_date(Date cmmt_date) {
		this.cmmt_date = cmmt_date;
	}
	
	public String getCmmt_pict_afat() {
		return cmmt_pict_afat;
	}
	
	public void setCmmt_pict_afat(String cmmt_pict_afat) {
		this.cmmt_pict_afat = cmmt_pict_afat;
	}
	
	public String getAdmin_id() {
		return admin_id;
	}
	
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	
	public String getMbr_id() {
		return mbr_id;
	}
	
	public void setMbr_id(String mbr_id) {
		this.mbr_id = mbr_id;
	}
}