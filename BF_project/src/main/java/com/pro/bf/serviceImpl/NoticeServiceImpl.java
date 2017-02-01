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
	
	static int counts = 15; // 페이지 내의 공지사항 개수
	static int view_rows = 5; // 페이지 개수
	
	@Override
	public ArrayList<NoticeVO> noticeList(int page, String search) throws SQLException { // 공지사항 리스트
		
		if(search.equals("")){ // 검색어가 없을경우
			search = "%";
		}
		
		int startRow = -1; // 
		int endRow = -1; // 
		int totalRecord = totalRecord(search); // 공지사항 전체 개수
		
		startRow = (page-1) * counts; // 초기값 0 --> 현재 몇페이지인지에 대해 제일 먼저 시작하는 공지사항 글
		endRow = startRow + counts - 1; // 9 --> 현재 몇페이지인지에 대해 제일 끝에 있는 공지사항 글
		if(endRow > totalRecord)
			endRow = totalRecord;
		
		ArrayList<NoticeVO> noticeList = noticeDao.noticeList(search, startRow, counts);
		
		return noticeList;
	}
	
	// 공지사항 전체 개수<검색어로>
	public int totalRecord(String search) throws SQLException{
		int total_pages = 0; // 공지사항 전체 개수
		total_pages = noticeDao.totalRecord(search);
		return total_pages;
	}

	@Override
	public String pageNumber(int page, String search) throws SQLException {
		String str = "";
		int total_pages = totalRecord(search); // 공지사항 전체 개수
		int page_count = total_pages / counts + 1; // 페이지 개수
		
		if(total_pages % counts == 0){
			page_count--;
		}
		if(page < 1){
			page = 1;
		}
		int start_page = page - (page % view_rows) + 1;
		for(int i=page_count; i>=1; i--){
			if(page % 5 == 0){
				int a = page / 5;
				if(a==1){
					start_page = 1;
				}else{
					start_page = a + (4*(a-1));
				}
			}
		}
		int end_page = start_page + (view_rows - 1);
		
		if(end_page > page_count){
			end_page = page_count;
		}
		
		if(start_page > view_rows){
			str += "<a href='notice?page=1&search="+search+"'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='notice?page="+(start_page-1)+"&search=" + search + "'>&lt;</a>&nbsp;&nbsp;";			
		}
		
		for(int i = start_page; i<=end_page; i++){
			if(i==page){
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>";
			}else{
				str += "<a href='notice?page="+i+"&search="+search+"'>["+i+"]</a>&nbsp;&nbsp;";
			}
		}
		
		if(page_count > end_page){
			str += "<a href='notice?page="+(end_page+1)+"&search=" + search + "'>&gt;</a>&nbsp;&nbsp;";
			str += "<a href='notice?page="+page_count+"&search="+search+"'>&gt;&gt; </a>&nbsp;&nbsp;";
		}

		return str;
	}

	@Override
	public void insertNotice(NoticeVO noticeVo) throws SQLException { // 공지사항 등록
		noticeDao.insertNotice(noticeVo);
	}
}