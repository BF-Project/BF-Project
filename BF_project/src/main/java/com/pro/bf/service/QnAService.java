package com.pro.bf.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pro.bf.dto.QnAVO;

public interface QnAService {

	public ArrayList<QnAVO> getQnaList(int tpage) throws SQLException; // Q&A

	public QnAVO getQnaDetail(String qna_num) throws SQLException; // 상세보기

	public void insertQna(QnAVO qnaVO) throws SQLException;

	public int updateQna(QnAVO qnaVO) throws SQLException; // 답글수정

	public int countQna(QnAVO qnaVO) throws SQLException; // 조회수

	public String pageNumber(int tpage) throws SQLException;
	

 	
	
}
