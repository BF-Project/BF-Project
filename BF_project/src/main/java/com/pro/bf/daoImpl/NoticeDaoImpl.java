package com.pro.bf.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.pro.bf.dao.NoticeDao;
import com.pro.bf.dto.NoticeVO;

public class NoticeDaoImpl implements NoticeDao{

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client = client;
	}
	
	@Override
	public ArrayList<NoticeVO> noticeList(String search, int startRow, int counts) throws SQLException { // 공지사항 리스트 받아오기
		ArrayList<NoticeVO> noticeList = (ArrayList<NoticeVO>)client.queryForList("noticeList", search, startRow, counts);
		return noticeList;
	}

	@Override
	public int totalRecord(String search) throws SQLException { // 공지사항 전체 개수
		int total_pages = (Integer)client.queryForObject("totalRecord", search);
		return total_pages;
	}

	@Override
	public void insertNotice(NoticeVO noticeVo) throws SQLException {
		client.insert("insertNotice", noticeVo);
	}
}