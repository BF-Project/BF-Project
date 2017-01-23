package com.pro.bf.dto;

import java.sql.Date;

/**
 * @author 차승현	<br>
 * Q & A 게시판 테이블
 */
public class QnAVO {

	private int qna_num; // key, 게시글 일련번호
	private String qna_title; // 제목
	private String qna_content; // 내용
	private int qna_cnt; // 조회수
	private Date qna_date; // 게시글 게시날짜
	private String qna_pict_afat; // 파일첨부(사진이름)
	private String mbr_id; // 회원이름(FK)
	
	public int getQna_num() {
		return qna_num;
	}
	
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	
	public String getQna_title() {
		return qna_title;
	}
	
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	
	public String getQna_content() {
		return qna_content;
	}
	
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	
	public int getQna_cnt() {
		return qna_cnt;
	}
	
	public void setQna_cnt(int qna_cnt) {
		this.qna_cnt = qna_cnt;
	}
	
	public Date getQna_date() {
		return qna_date;
	}
	
	public void setQna_date(Date qna_date) {
		this.qna_date = qna_date;
	}
	
	public String getQna_pict_afat() {
		return qna_pict_afat;
	}
	
	public void setQna_pict_afat(String qna_pict_afat) {
		this.qna_pict_afat = qna_pict_afat;
	}
	
	public String getMbr_id() {
		return mbr_id;
	}
	
	public void setMbr_id(String mbr_id) {
		this.mbr_id = mbr_id;
	}
}