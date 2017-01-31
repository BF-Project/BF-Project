package com.pro.bf.dto;

/**
 * @author 차승현<br>
 * 이메일을 보내기위해 정보를 담는 VO클래스
 */
public class EmailVO {

	private String sender; // 보내는 사람 / 운영자
	private String to; // 받는 사람
	private String context; // 내용
	private String title; // 제목
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}