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
	public ArrayList<NoticeVO> noticeList(String key) throws SQLException { // 공지사항 리스트 받아오기
		ArrayList<NoticeVO> noticeList = (ArrayList<NoticeVO>)client.queryForList("noticeList", key);
		return noticeList;
	}
}