package com.pro.bf.dto;

import java.sql.Date;

/**
 * @author 차승현<br>
 * 자유게시판 테이블
 */
public class FreeVO {
	
	private int fre_num; // key, 자유게시판 게시글 번호
	private String fre_title; // 제목
	private String fre_content; // 내용
	private Date fre_date; // 게시글 생성날짜(sysdate)
	private int fre_cnt; // 조회수
	private String fre_pict_afat; // 사진첨부(파일이름)
	private String admin_id; // 관리자 아이디(FK)
	private String mbr_id; // 회원 아이디(FK)
	
	public int getFre_num() {
		return fre_num;
	}
	
	public void setFre_num(int fre_num) {
		this.fre_num = fre_num;
	}
	
	public String getFre_title() {
		return fre_title;
	}
	
	public void setFre_title(String fre_title) {
		this.fre_title = fre_title;
	}
	
	public String getFre_content() {
		return fre_content;
	}
	
	public void setFre_content(String fre_content) {
		this.fre_content = fre_content;
	}
	
	public Date getFre_date() {
		return fre_date;
	}
	
	public void setFre_date(Date fre_date) {
		this.fre_date = fre_date;
	}
	
	public int getFre_cnt() {
		return fre_cnt;
	}
	
	public void setFre_cnt(int fre_cnt) {
		this.fre_cnt = fre_cnt;
	}
	
	public String getFre_pict_afat() {
		return fre_pict_afat;
	}
	
	public void setFre_pict_afat(String fre_pict_afat) {
		this.fre_pict_afat = fre_pict_afat;
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