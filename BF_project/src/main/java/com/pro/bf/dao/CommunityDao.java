package com.pro.bf.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pro.bf.dto.CommunityVO;
import com.pro.bf.dto.QnAVO;

public interface CommunityDao {

	public ArrayList<CommunityVO> listCmmt(String mbr_id , String admin_id) throws SQLException; // Q&A 리스트

	public ArrayList<CommunityVO> listAllCmmt(int tpage) throws SQLException; // Q&A ALL 리스트

	public CommunityVO getCmmt(int cmmt_num) throws SQLException;

	public void insertCmmt(CommunityVO cmmtVO) throws SQLException; // 등록

	public int updateCmmt(CommunityVO cmmtVO) throws SQLException; // 수정
	
	public int countCmmt(CommunityVO cmmtVO) throws SQLException; // 조회수

	public int totalCmmt() throws SQLException;

	public void deleteCmmt(int Cmmt_num)throws SQLException;//delete
	
}
