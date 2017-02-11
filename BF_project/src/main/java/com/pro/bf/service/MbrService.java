package com.pro.bf.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.pro.bf.dto.CommunityVO;
import com.pro.bf.dto.MbrVO;
import com.pro.bf.dto.QnAVO;

public interface MbrService {

	void insertMember(MbrVO mbrVo) throws SQLException;

	String idCheck(String idcheck) throws SQLException;

	String login(MbrVO mbrVo) throws SQLException;

	String searchUserName(String login) throws SQLException;

	String searchUserId(MbrVO mbrVo) throws SQLException;

	Map searchUserPwd(MbrVO mbrVo) throws SQLException;

}
