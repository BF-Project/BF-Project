package com.pro.bf.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.pro.bf.daoImpl.FreeDaoImpl;
import com.pro.bf.dto.FreeVO;
import com.pro.bf.service.FreeService;

public class FreeServiceImpl implements FreeService{

	@Autowired
	FreeDaoImpl freeDaoImpl;
	
	public void setFreeDAO(FreeDaoImpl freeDaoImpl){
		this.freeDaoImpl = freeDaoImpl;
	}
	
	@Override
	public ArrayList<FreeVO> freeList(String mbr_id) throws SQLException {
		ArrayList<FreeVO> freeList = freeDaoImpl.freeList(mbr_id);
		return freeList;
	}

	@Override
	public void insertFree(FreeVO freeVO) throws SQLException {
		freeDaoImpl.insertFree(freeVO);
		
	}

}
