package com.pro.bf.dto;

import java.sql.Date;

/**
 * @author 차승현 <br>
 * 결제 테이블
 */
public class PaymentVO {

	private int payment_num; // key, 일련번호
	private char payment_rfd; // 환불여부(default : N)
	private String payment_money; // 결제금액
	private int payment_quty; // 잔여사용횟수
	private Date payment_date; // 결제날짜
	private char c_phone_payment; // 핸드폰결제 여부
	private char card_payment; // 카드결제 여부
	private char npb_payment; // 무통장결제 여부
	private String mbr_id; // 회원아이디(FK)
	
	public int getPayment_num() {
		return payment_num;
	}
	
	public void setPayment_num(int payment_num) {
		this.payment_num = payment_num;
	}
	
	public char getPayment_rfd() {
		return payment_rfd;
	}
	
	public void setPayment_rfd(char payment_rfd) {
		this.payment_rfd = payment_rfd;
	}
	
	public String getPayment_money() {
		return payment_money;
	}
	
	public void setPayment_money(String payment_money) {
		this.payment_money = payment_money;
	}
	
	public int getPayment_quty() {
		return payment_quty;
	}
	
	public void setPayment_quty(int payment_quty) {
		this.payment_quty = payment_quty;
	}
	
	public Date getPayment_date() {
		return payment_date;
	}
	
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	
	public char getC_phone_payment() {
		return c_phone_payment;
	}
	
	public void setC_phone_payment(char c_phone_payment) {
		this.c_phone_payment = c_phone_payment;
	}
	
	public char getCard_payment() {
		return card_payment;
	}
	
	public void setCard_payment(char card_payment) {
		this.card_payment = card_payment;
	}
	
	public char getNpb_payment() {
		return npb_payment;
	}
	
	public void setNpb_payment(char npb_payment) {
		this.npb_payment = npb_payment;
	}
	
	public String getMbr_id() {
		return mbr_id;
	}
	
	public void setMbr_id(String mbr_id) {
		this.mbr_id = mbr_id;
	}
}