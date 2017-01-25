package com.pro.bf.dto;

/**
 * @author 차승현 <br>
 * 주소 테이블
 */
public class AddrVO {
	
	private String addr_zip_num; // 우편번호?
	private String addr_sd; // 시도
	private String addr_gugun; // 구군
	private String addr_dong; // 동
	private int addr_zip_code; // 각 지역에 매긴 번호 
	private String addr_bunji; // 번지
	
	@Override
	public String toString() {
		return "AddrVO [addr_zip_num=" + addr_zip_num + ", addr_sd=" + addr_sd
				+ ", addr_gugun=" + addr_gugun + ", addr_dong=" + addr_dong
				+ ", addr_zip_code=" + addr_zip_code + ", addr_bunji="
				+ addr_bunji + "]";
	}

	public String getAddr_zip_num() {
		return addr_zip_num;
	}
	
	public void setAddr_zip_num(String addr_zip_num) {
		this.addr_zip_num = addr_zip_num;
	}
	
	public String getAddr_sd() {
		return addr_sd;
	}
	
	public void setAddr_sd(String addr_sd) {
		this.addr_sd = addr_sd;
	}
	
	public String getAddr_gugun() {
		return addr_gugun;
	}
	
	public void setAddr_gugun(String addr_gugun) {
		this.addr_gugun = addr_gugun;
	}
	
	public String getAddr_dong() {
		return addr_dong;
	}
	
	public void setAddr_dong(String addr_dong) {
		this.addr_dong = addr_dong;
	}
	
	public int getAddr_zip_code() {
		return addr_zip_code;
	}
	
	public void setAddr_zip_code(int addr_zip_code) {
		this.addr_zip_code = addr_zip_code;
	}
	
	public String getAddr_bunji() {
		return addr_bunji;
	}
	
	public void setAddr_bunji(String addr_bunji) {
		this.addr_bunji = addr_bunji;
	}
}