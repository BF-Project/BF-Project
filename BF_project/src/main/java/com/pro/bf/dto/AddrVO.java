package com.pro.bf.dto;

/**
 * @author 차승현 <br>
 * 주소 테이블
 */
public class AddrVO {
	
	private int addr_srl_num; // key, 주소 일련번호
	private String addr_zce_num; // 우편번호
	private String addr_sd; // 시도
	private String addr_ggn; // 구군
	private String addr_dong; // 동
	private String addr_fsz_scz; //본번_부번
	
	public int getAddr_srl_num() {
		return addr_srl_num;
	}
	
	public void setAddr_srl_num(int addr_srl_num) {
		this.addr_srl_num = addr_srl_num;
	}
	
	public String getAddr_zce_num() {
		return addr_zce_num;
	}
	
	public void setAddr_zce_num(String addr_zce_num) {
		this.addr_zce_num = addr_zce_num;
	}
	
	public String getAddr_sd() {
		return addr_sd;
	}
	
	public void setAddr_sd(String addr_sd) {
		this.addr_sd = addr_sd;
	}
	
	public String getAddr_ggn() {
		return addr_ggn;
	}
	
	public void setAddr_ggn(String addr_ggn) {
		this.addr_ggn = addr_ggn;
	}
	
	public String getAddr_dong() {
		return addr_dong;
	}
	
	public void setAddr_dong(String addr_dong) {
		this.addr_dong = addr_dong;
	}
	
	public String getAddr_fsz_scz() {
		return addr_fsz_scz;
	}
	
	public void setAddr_fsz_scz(String addr_fsz_scz) {
		this.addr_fsz_scz = addr_fsz_scz;
	}
}