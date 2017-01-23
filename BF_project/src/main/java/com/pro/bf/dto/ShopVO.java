package com.pro.bf.dto;

/**
 * @author 차승현<br>
 * 상가업소 테이블
 */
public class ShopVO {

	private int shop_num; // key, 상가 일련번호
	private String shop_dong_addr; // 행정동 명
	private String shop_nm; // 상호명
	private String shop_cmc_L; // 상가 상권업종_대
	private String shop_cmc_M; // 상가 상권업종_중
	private String shop_addr; // 상가지번주소
	
	public int getShop_num() {
		return shop_num;
	}
	
	public void setShop_num(int shop_num) {
		this.shop_num = shop_num;
	}
	
	public String getShop_dong_addr() {
		return shop_dong_addr;
	}
	
	public void setShop_dong_addr(String shop_dong_addr) {
		this.shop_dong_addr = shop_dong_addr;
	}
	
	public String getShop_nm() {
		return shop_nm;
	}
	
	public void setShop_nm(String shop_nm) {
		this.shop_nm = shop_nm;
	}
	
	public String getShop_cmc_L() {
		return shop_cmc_L;
	}
	
	public void setShop_cmc_L(String shop_cmc_L) {
		this.shop_cmc_L = shop_cmc_L;
	}
	
	public String getShop_cmc_M() {
		return shop_cmc_M;
	}
	
	public void setShop_cmc_M(String shop_cmc_M) {
		this.shop_cmc_M = shop_cmc_M;
	}
	
	public String getShop_addr() {
		return shop_addr;
	}
	
	public void setShop_addr(String shop_addr) {
		this.shop_addr = shop_addr;
	}
}