package com.pro.bf.service;

import java.sql.SQLException;
import java.util.List;

import com.pro.bf.dto.CmmtCmtVO;

public interface CmmtCmtService {

	
	public List<CmmtCmtVO> cmmtcmtAllList(int cmmtcmt_num) throws SQLException;
	public void intsertCmmtcmt(CmmtCmtVO cmmtcmtVO) throws SQLException;

	//댓글삭제
	public int deleteCmmtcmt(int cmmtcmt_num) throws SQLException;
	public List<CmmtCmtVO> cmmtcmtListAn(int cmmtcmt_num) throws SQLException;

}
