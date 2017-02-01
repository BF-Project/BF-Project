package com.pro.bf.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pro.bf.dto.NoticeVO;

public interface NoticeDao {

	ArrayList<NoticeVO> noticeList(String key) throws SQLException; 
}
