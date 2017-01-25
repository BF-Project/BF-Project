package com.pro.bf.dao;

import java.sql.SQLException;

import com.pro.bf.dto.MbrVO;

public interface MbrDao {

	void insertMember(MbrVO mbrVo) throws SQLException;
	String idCheck(String userid) throws SQLException;
}
