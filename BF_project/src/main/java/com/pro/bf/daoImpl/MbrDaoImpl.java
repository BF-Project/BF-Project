package com.pro.bf.daoImpl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.pro.bf.dao.MbrDao;
import com.pro.bf.dto.MbrVO;

public class MbrDaoImpl implements MbrDao{

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client = client;
	}
	
	@Override
	public void insertMember(MbrVO mbrVo) throws SQLException { // 회원가입
		client.insert("insertMember", mbrVo);
	}

	@Override
	public String idCheck(String userid) throws SQLException { // 아이디 중복확인
		String data = (String)client.queryForObject("idcheck", userid);
		System.out.println("1 내가 입력한 아이디 값 " + userid);
		System.out.println("2 리턴받은 아이디 값(Dao) " + data);
		return data;
	}

	@Override
	public String login(MbrVO mbrVo) throws SQLException { // 로그인
		String login = (String)client.queryForObject("login", mbrVo);
		return login;
	}

	@Override
	public String searchUserName(String login) throws SQLException { // 로그인한 유저 이름 찾기
		String loginUserName = (String)client.queryForObject("SearchLoginUserName", login);
		return loginUserName;
	}
}