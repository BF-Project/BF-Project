package com.pro.bf.dao;

import java.sql.SQLException;
import java.util.List;

import com.pro.bf.dto.CmtVO;

public interface CmtDao {

	public List<CmtVO> cmtAllList(int cmt_num) throws SQLException;
}
