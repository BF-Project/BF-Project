package com.pro.bf.dto;

/**
 * @author 차승현<br>
 * 유동인구 테이블
 */
public class PopulationVO {
	
	private int pplt_num; // key, 일련번호
	private String pplt_dong; // 읍면동
	private int pplt_man; // 내국인 남
	private int pplt_woman; // 내국인 여
	private int pplt_frn_man; // 외국인 남
	private int pplt_frn_woman; // 외국인 여
	
	public int getPplt_num() {
		return pplt_num;
	}
	
	public void setPplt_num(int pplt_num) {
		this.pplt_num = pplt_num;
	}
	
	public String getPplt_dong() {
		return pplt_dong;
	}
	
	public void setPplt_dong(String pplt_dong) {
		this.pplt_dong = pplt_dong;
	}
	
	public int getPplt_man() {
		return pplt_man;
	}
	
	public void setPplt_man(int pplt_man) {
		this.pplt_man = pplt_man;
	}
	
	public int getPplt_woman() {
		return pplt_woman;
	}
	
	public void setPplt_woman(int pplt_woman) {
		this.pplt_woman = pplt_woman;
	}
	
	public int getPplt_frn_man() {
		return pplt_frn_man;
	}
	
	public void setPplt_frn_man(int pplt_frn_man) {
		this.pplt_frn_man = pplt_frn_man;
	}
	
	public int getPplt_frn_woman() {
		return pplt_frn_woman;
	}
	
	public void setPplt_frn_woman(int pplt_frn_woman) {
		this.pplt_frn_woman = pplt_frn_woman;
	}
}