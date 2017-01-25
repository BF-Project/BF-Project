package com.pro.bf.serviceImpl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.pro.bf.daoImpl.MbrDaoImpl;
import com.pro.bf.dto.MbrVO;
import com.pro.bf.service.MbrService;

public class MbrServiceImpl implements MbrService{

	@Autowired
	private MbrDaoImpl mbrDao;
	public void setMbrDAO(MbrDaoImpl mbrDao){
		this.mbrDao = mbrDao;
	}
	
	
	@Override
	public void insertMember(MbrVO mbrVo) throws SQLException { // 회원가입
		mbrDao.insertMember(mbrVo);
	}

	@Override
	public String idCheck(String idcheck) throws SQLException { // 아이디 중복확인
		String data = mbrDao.idCheck(idcheck);
		System.out.println("3 리턴받은 아이디 값(Service) " + data);
		return data;
	}
}