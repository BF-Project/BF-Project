package com.pro.bf.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.pro.bf.daoImpl.NoticeDaoImpl;
import com.pro.bf.dto.NoticeVO;
import com.pro.bf.service.NoticeService;

public class NoticeServiceImpl implements NoticeService{

	@Autowired
	NoticeDaoImpl noticeDao;
	public void setNoticeDAO(NoticeDaoImpl noticeDao){
		this.noticeDao = noticeDao;
	}
	
	@Override
	public ArrayList<NoticeVO> noticeList(String key) throws SQLException { // 공지사항 리스트
		ArrayList<NoticeVO> noticeList = noticeDao.noticeList(key);
		return noticeList;
	}
}