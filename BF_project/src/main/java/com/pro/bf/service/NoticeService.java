package com.pro.bf.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pro.bf.dto.NoticeVO;

public interface NoticeService {

	ArrayList<NoticeVO> noticeList(String key) throws SQLException;
	
}
