package com.pro.bf.dto;

/**
 * @author 차승현<br>
 * 온라인 창업 테이블 ( DB table 명 : ONLINE_ )
 */
public class OnlineVO {

	private int ole_num; // key, 일련번호
	private char ole_trd_sts; // 사업여부
	private char ole_mkt_sts; // 마케팅여부
	private char ole_pdt_sts; // 상품관리여부
	private char ole_psl_pdt_sts; // 물리적상품관리여부
	private char ole_dgt_pdt_sts; // 디지털상품여부
	private char ole_pfbl_sts; // 수익성분석여부
	private char ole_siteMap_sts; // 사이트맵여부
	private char ole_pdt_prdt_sts; // 상품직접성산여부
	private char ole_copt_cnc_sts; // 제조협력업체여부
	private char ole_item_orgt_sts; // 아이템독창성여부
	private char ole_cstm_ast_sts; // 고객관리계획여부
	private String ole_asst; // 보유자산
	private String mbr_id; // 회원 아이디(FK)
	
	public int getOle_num() {
		return ole_num;
	}
	
	public void setOle_num(int ole_num) {
		this.ole_num = ole_num;
	}
	
	public char getOle_trd_sts() {
		return ole_trd_sts;
	}
	
	public void setOle_trd_sts(char ole_trd_sts) {
		this.ole_trd_sts = ole_trd_sts;
	}
	
	public char getOle_mkt_sts() {
		return ole_mkt_sts;
	}
	
	public void setOle_mkt_sts(char ole_mkt_sts) {
		this.ole_mkt_sts = ole_mkt_sts;
	}
	
	public char getOle_pdt_sts() {
		return ole_pdt_sts;
	}
	
	public void setOle_pdt_sts(char ole_pdt_sts) {
		this.ole_pdt_sts = ole_pdt_sts;
	}
	
	public char getOle_psl_pdt_sts() {
		return ole_psl_pdt_sts;
	}
	
	public void setOle_psl_pdt_sts(char ole_psl_pdt_sts) {
		this.ole_psl_pdt_sts = ole_psl_pdt_sts;
	}
	
	public char getOle_dgt_pdt_sts() {
		return ole_dgt_pdt_sts;
	}
	
	public void setOle_dgt_pdt_sts(char ole_dgt_pdt_sts) {
		this.ole_dgt_pdt_sts = ole_dgt_pdt_sts;
	}
	
	public char getOle_pfbl_sts() {
		return ole_pfbl_sts;
	}
	
	public void setOle_pfbl_sts(char ole_pfbl_sts) {
		this.ole_pfbl_sts = ole_pfbl_sts;
	}
	
	public char getOle_siteMap_sts() {
		return ole_siteMap_sts;
	}
	
	public void setOle_siteMap_sts(char ole_siteMap_sts) {
		this.ole_siteMap_sts = ole_siteMap_sts;
	}
	
	public char getOle_pdt_prdt_sts() {
		return ole_pdt_prdt_sts;
	}
	
	public void setOle_pdt_prdt_sts(char ole_pdt_prdt_sts) {
		this.ole_pdt_prdt_sts = ole_pdt_prdt_sts;
	}
	
	public char getOle_copt_cnc_sts() {
		return ole_copt_cnc_sts;
	}
	
	public void setOle_copt_cnc_sts(char ole_copt_cnc_sts) {
		this.ole_copt_cnc_sts = ole_copt_cnc_sts;
	}
	
	public char getOle_item_orgt_sts() {
		return ole_item_orgt_sts;
	}
	
	public void setOle_item_orgt_sts(char ole_item_orgt_sts) {
		this.ole_item_orgt_sts = ole_item_orgt_sts;
	}
	
	public char getOle_cstm_ast_sts() {
		return ole_cstm_ast_sts;
	}
	
	public void setOle_cstm_ast_sts(char ole_cstm_ast_sts) {
		this.ole_cstm_ast_sts = ole_cstm_ast_sts;
	}
	
	public String getOle_asst() {
		return ole_asst;
	}
	
	public void setOle_asst(String ole_asst) {
		this.ole_asst = ole_asst;
	}
	
	public String getMbr_id() {
		return mbr_id;
	}
	
	public void setMbr_id(String mbr_id) {
		this.mbr_id = mbr_id;
	}
}