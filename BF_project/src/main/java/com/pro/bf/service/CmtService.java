package com.pro.bf.service;

import java.sql.SQLException;
import java.util.List;

import com.pro.bf.dto.CmtVO;

public interface CmtService {

	public List<CmtVO> cmtAllList(int cmt_num) throws SQLException;
}