package com.pro.bf.dto;

/**
 * @author 차승현<br>
 * 오프라인 창업 테이블 ( DB table 명 : OFFLINE_ )
 */
public class OfflineVO {

	private int off_num; // key, 일련번호
	private String off_kind; // 창업종류
	private String off_asst; // 보유자산
	private String off_datailAddr; // 상세주소 입력
	private int pplt_num; // 인구 일련번호(FK)
	private int trt_num; // 관광 일련번호(FK)
	private int shop_num; // 상가 일련번호(FK)
	private int lent_num; // 임대 일련번호(FK)
	private int flo_num; // 유동인구 일련번호(FK)
	private int mt_num; // 숙박 일련번호(FK)
	private String mbr_id; // 회원아이디(FK)
	
	public int getOff_num() {
		return off_num;
	}
	
	public void setOff_num(int off_num) {
		this.off_num = off_num;
	}
	
	public String getOff_kind() {
		return off_kind;
	}
	
	public void setOff_kind(String off_kind) {
		this.off_kind = off_kind;
	}
	
	public String getOff_asst() {
		return off_asst;
	}
	
	public void setOff_asst(String off_asst) {
		this.off_asst = off_asst;
	}
	
	public String getOff_datailAddr() {
		return off_datailAddr;
	}
	
	public void setOff_datailAddr(String off_datailAddr) {
		this.off_datailAddr = off_datailAddr;
	}
	
	public int getPplt_num() {
		return pplt_num;
	}
	
	public void setPplt_num(int pplt_num) {
		this.pplt_num = pplt_num;
	}
	
	public int getTrt_num() {
		return trt_num;
	}
	
	public void setTrt_num(int trt_num) {
		this.trt_num = trt_num;
	}
	
	public int getShop_num() {
		return shop_num;
	}
	
	public void setShop_num(int shop_num) {
		this.shop_num = shop_num;
	}
	
	public int getLent_num() {
		return lent_num;
	}
	
	public void setLent_num(int lent_num) {
		this.lent_num = lent_num;
	}
	
	public int getFlo_num() {
		return flo_num;
	}
	
	public void setFlo_num(int flo_num) {
		this.flo_num = flo_num;
	}
	
	public int getMt_num() {
		return mt_num;
	}
	
	public void setMt_num(int mt_num) {
		this.mt_num = mt_num;
	}
	
	public String getMbr_id() {
		return mbr_id;
	}
	
	public void setMbr_id(String mbr_id) {
		this.mbr_id = mbr_id;
	}
}