package com.pro.bf.dto;

/**
 * @author 차승현<br>
 * 관광지 테이블
 */
public class TouristVO {

	private int trt_num; // key, 관광지 일련번호
	private String trt_nm; // 관광지명
	private String trt_addr; // 관광지 주소
	private int trt_grade; // 관광지 등급(1등급일수록 사람이 많음)
	
	public int getTrt_num() {
		return trt_num;
	}
	
	public void setTrt_num(int trt_num) {
		this.trt_num = trt_num;
	}
	
	public String getTrt_nm() {
		return trt_nm;
	}
	
	public void setTrt_nm(String trt_nm) {
		this.trt_nm = trt_nm;
	}
	
	public String getTrt_addr() {
		return trt_addr;
	}
	
	public void setTrt_addr(String trt_addr) {
		this.trt_addr = trt_addr;
	}
	
	public int getTrt_grade() {
		return trt_grade;
	}
	
	public void setTrt_grade(int trt_grade) {
		this.trt_grade = trt_grade;
	}
}