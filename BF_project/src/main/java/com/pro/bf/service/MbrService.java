package com.pro.bf.service;

import java.sql.SQLException;

import com.pro.bf.dto.MbrVO;

public interface MbrService {

	void insertMember(MbrVO mbrVo) throws SQLException; 
	String idCheck(String idcheck) throws SQLException; 
	String login(MbrVO mbrVo) throws SQLException;
	String searchUserName(String login) throws SQLException;
}
