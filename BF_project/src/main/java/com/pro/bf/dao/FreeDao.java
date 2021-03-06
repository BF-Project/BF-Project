package com.pro.bf.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pro.bf.dto.CmtVO;
import com.pro.bf.dto.FreeVO;

public interface FreeDao {

	public ArrayList<FreeVO> listAllFree(int tpage) throws SQLException;
	public ArrayList<FreeVO> freeList(String mbr_id) throws SQLException;
	public ArrayList<FreeVO> freSearch(String fre_title) throws SQLException;
	public FreeVO getFree(int fre_num) throws SQLException;
	public void insertFree(FreeVO freeVO) throws SQLException;
	public void deleteFree(int fre_num) throws SQLException;
	public int updateFree(FreeVO freeVO) throws SQLException;
	public int countFree(FreeVO freeVO) throws SQLException;
	public int totalFree() throws SQLException;
}
