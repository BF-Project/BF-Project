package com.pro.bf.dto;

import java.sql.Date;

/**
 * @author 차승현<br>
 * 공지사항 테이블
 */
public class NoticeVO {

	private int notice_num; // key, 공지사항 게시글 번호
	private String notice_title; // 제목
	private String notice_content; // 내용
	private int notice_cnt; // 조회수
	private Date notice_date; // 게시날짜
	private String notice_pict_afat; // 첨부파일(사진이름)
	private String admin_id; // 관리자 아이디(FK)
	
	@Override
	public String toString() {
		return "NoticeVO [notice_num=" + notice_num + ", notice_title="
				+ notice_title + ", notice_content=" + notice_content
				+ ", notice_cnt=" + notice_cnt + ", notice_date=" + notice_date
				+ ", notice_pict_afat=" + notice_pict_afat + ", admin_id="
				+ admin_id + "]";
	}

	public int getNotice_num() {
		return notice_num;
	}
	
	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}
	
	public String getNotice_title() {
		return notice_title;
	}
	
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	
	public String getNotice_content() {
		return notice_content;
	}
	
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	
	public int getNotice_cnt() {
		return notice_cnt;
	}
	
	public void setNotice_cnt(int notice_cnt) {
		this.notice_cnt = notice_cnt;
	}
	
	public Date getNotice_date() {
		return notice_date;
	}
	
	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}
	
	public String getNotice_pict_afat() {
		return notice_pict_afat;
	}
	
	public void setNotice_pict_afat(String notice_pict_afat) {
		this.notice_pict_afat = notice_pict_afat;
	}
	
	public String getAdmin_id() {
		return admin_id;
	}
	
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
}