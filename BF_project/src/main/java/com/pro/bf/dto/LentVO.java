package com.pro.bf.dto;

/**
 * @author 차승현<br>
 * 임대가격 테이블
 */
public class LentVO {
	
	private int lent_num; // key, 일련번호
	private String lent_dong; // 동
	private int lent_firstzip; // 본번
	private int secondzip; // 부번
	private String lent_price; // 공시가격
	
	public int getLent_num() {
		return lent_num;
	}
	
	public void setLent_num(int lent_num) {
		this.lent_num = lent_num;
	}
	
	public String getLent_dong() {
		return lent_dong;
	}
	
	public void setLent_dong(String lent_dong) {
		this.lent_dong = lent_dong;
	}
	
	public int getLent_firstzip() {
		return lent_firstzip;
	}
	
	public void setLent_firstzip(int lent_firstzip) {
		this.lent_firstzip = lent_firstzip;
	}
	
	public int getSecondzip() {
		return secondzip;
	}
	
	public void setSecondzip(int secondzip) {
		this.secondzip = secondzip;
	}
	
	public String getLent_price() {
		return lent_price;
	}
	
	public void setLent_price(String lent_price) {
		this.lent_price = lent_price;
	}
}