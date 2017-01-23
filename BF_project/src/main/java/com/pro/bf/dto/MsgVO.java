package com.pro.bf.dto;

import java.sql.Date;

/**
 * @author 차승현<br>
 * 메시지 테이블
 */
public class MsgVO {

	private int msg_num; // key, 일련번호
	private Date msg_sendDate; // 메시지 보낸날짜
	private char msg_check; // 메시지 확인여부(Y / N)
	private String msg_trm_content; // 발신 메시지 내용
	private String msg_rcv_content; // 수신 메시지 내용
	private String msg_trmt; // 발신자
	private String msg_rcvr; // 수신자
	private String mbr_id; // 회원아이디(PK)
	private String admin_id; // 관리자아이디(PK)
	
	public int getMsg_num() {
		return msg_num;
	}
	
	public void setMsg_num(int msg_num) {
		this.msg_num = msg_num;
	}
	
	public Date getMsg_sendDate() {
		return msg_sendDate;
	}
	
	public void setMsg_sendDate(Date msg_sendDate) {
		this.msg_sendDate = msg_sendDate;
	}
	
	public char getMsg_check() {
		return msg_check;
	}
	
	public void setMsg_check(char msg_check) {
		this.msg_check = msg_check;
	}
	
	public String getMsg_trm_content() {
		return msg_trm_content;
	}
	
	public void setMsg_trm_content(String msg_trm_content) {
		this.msg_trm_content = msg_trm_content;
	}
	
	public String getMsg_rcv_content() {
		return msg_rcv_content;
	}
	
	public void setMsg_rcv_content(String msg_rcv_content) {
		this.msg_rcv_content = msg_rcv_content;
	}
	
	public String getMsg_trmt() {
		return msg_trmt;
	}
	
	public void setMsg_trmt(String msg_trmt) {
		this.msg_trmt = msg_trmt;
	}
	
	public String getMsg_rcvr() {
		return msg_rcvr;
	}
	
	public void setMsg_rcvr(String msg_rcvr) {
		this.msg_rcvr = msg_rcvr;
	}
	
	public String getMbr_id() {
		return mbr_id;
	}
	
	public void setMbr_id(String mbr_id) {
		this.mbr_id = mbr_id;
	}
	
	public String getAdmin_id() {
		return admin_id;
	}
	
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
}