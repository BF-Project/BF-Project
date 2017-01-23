package com.pro.bf.dto;

import java.sql.Date;

/**
 * @author 차승현<br>
 * 견적 테이블 
 */
public class QttVO {

	private int qtt_srl_num; // key, 견적 일련번호
	private Date qtt_dt; // 견적날짜(sysdate)
	private String qtt_rest_pict; // 견적결과 사진(파일이름)
	private int ole_num; // 온라인일련번호(FK)
	private int off_num; // 오프라인일련번호(FK)
	
	public int getQtt_srl_num() {
		return qtt_srl_num;
	}
	
	public void setQtt_srl_num(int qtt_srl_num) {
		this.qtt_srl_num = qtt_srl_num;
	}
	
	public Date getQtt_dt() {
		return qtt_dt;
	}
	
	public void setQtt_dt(Date qtt_dt) {
		this.qtt_dt = qtt_dt;
	}
	
	public String getQtt_rest_pict() {
		return qtt_rest_pict;
	}
	
	public void setQtt_rest_pict(String qtt_rest_pict) {
		this.qtt_rest_pict = qtt_rest_pict;
	}
	
	public int getOle_num() {
		return ole_num;
	}
	
	public void setOle_num(int ole_num) {
		this.ole_num = ole_num;
	}
	
	public int getOff_num() {
		return off_num;
	}
	
	public void setOff_num(int off_num) {
		this.off_num = off_num;
	}
}