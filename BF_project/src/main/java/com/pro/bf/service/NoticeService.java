package com.pro.bf.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pro.bf.dto.NoticeVO;

public interface NoticeService {

	ArrayList<NoticeVO> noticeList(int page, String search) throws SQLException;
	String pageNumber(int page, String search) throws SQLException;
	void insertNotice(NoticeVO noticeVo) throws SQLException;
}
