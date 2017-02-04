package com.pro.bf.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pro.bf.daoImpl.CmtDaoImpl;
import com.pro.bf.dto.CmtVO;
import com.pro.bf.service.CmtService;

public class CmtServiceImpl implements CmtService{

	@Autowired
	CmtDaoImpl cmtDaoImpl;
	
	public void setCmtDAO(CmtDaoImpl cmtDaoImpl) {
		this.cmtDaoImpl = cmtDaoImpl;
	}

	@Override
	public List<CmtVO> cmtAllList(int cmt_num) throws SQLException {
		List<CmtVO> cmtAllList = cmtDaoImpl.cmtAllList(cmt_num);
		return cmtAllList;
	}

	@Override
	public void insertCmt(CmtVO cmtVO) throws SQLException {
		cmtDaoImpl.intsertCmt(cmtVO);
		
	}

	
}
