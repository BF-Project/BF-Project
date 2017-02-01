package com.pro.bf.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pro.bf.dto.FreeVO;

public interface FreeDao {

	public ArrayList<FreeVO> freeList(String mbr_id) throws SQLException;
	public void insertFree(FreeVO freeVO) throws SQLException;
}
