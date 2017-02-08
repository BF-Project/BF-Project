package com.pro.bf.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pro.bf.dto.CommunityVO;
import com.pro.bf.dto.QnAVO;

public interface CommunityService {
	
	public ArrayList<CommunityVO> getCmmtList(int tpage,String search) throws SQLException; // Q&A

	public CommunityVO getCmmtDetail(int cmmt_num) throws SQLException; // 상세보기

	public void insertCmmt(CommunityVO cmmtVO) throws SQLException;

	public int updateCmmt(CommunityVO cmmtVO) throws SQLException; // 답글수정

	public int countCmmt(CommunityVO cmmtVO) throws SQLException; // 조회수

	public String pageNumber(int tpage,String search) throws SQLException;

}
