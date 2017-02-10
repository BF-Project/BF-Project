package com.pro.bf.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.pro.bf.dao.CommunityDao;
import com.pro.bf.dao.QnADao;
import com.pro.bf.daoImpl.CommunityDaoImpl;
import com.pro.bf.daoImpl.QnADaoImpl;
import com.pro.bf.dto.CommunityVO;
import com.pro.bf.service.CommunityService;

@Service
public class CommunityServiceImpl implements CommunityService{

	@Autowired
	CommunityDao cmmtDao;
	
	@Autowired
	CommunityDaoImpl cmmtDaoImpl;

	private SqlMapClient client;
	
	static int view_rows = 10; // 페이지의 개수
	static int counts = 10; // 한 페이지에 나타낼 게시글 개수
	
	
	
	public void setCmmtDao(CommunityDao cmmtDao) {
		this.cmmtDao = cmmtDao;
	}

	public void setCmmtDaoImpl(CommunityDaoImpl cmmtDaoImpl) {
		this.cmmtDaoImpl = cmmtDaoImpl;
	}

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public ArrayList<CommunityVO> getCmmtList(int tpage,String search) throws SQLException {
		ArrayList<CommunityVO> cmmtList=cmmtDao.listAllCmmt(tpage,search);
		return cmmtList;
	}

	@Override
	public CommunityVO getCmmtDetail(int cmmt_num) throws SQLException {
		CommunityVO cmmtVO=cmmtDao.getCmmt(cmmt_num);
		return cmmtVO;
	}

	@Override
	public void insertCmmt(CommunityVO cmmtVO) throws SQLException {
		// TODO Auto-generated method stub
		cmmtDao.insertCmmt(cmmtVO);
		
	}

	@Override
	public int updateCmmt(CommunityVO cmmtVO) throws SQLException {
		// TODO Auto-generated method stub
		cmmtDao.updateCmmt(cmmtVO);
		return 0;
	}

	@Override
	public int countCmmt(CommunityVO cmmtVO) throws SQLException {
		// TODO Auto-generated method stub
		cmmtDao.countCmmt(cmmtVO);
		return 0;
	}

	@Override
	public String pageNumber(int tpage,String search) throws SQLException {
		String str="";
		int page_count =0;
		int total_pages=cmmtDaoImpl.totalCmmt(search);
		page_count = total_pages / counts + 1;
		
		if(total_pages % counts == 0) {
			page_count--;
		}
		
		if(tpage < 1) {
			tpage = 1;
		}
		
		int start_page = tpage - (tpage % view_rows) + 1;
		
		for(int i=page_count; i>=1; i--){
			if(tpage % 5 == 0){
				int a = tpage / 5;
				if(a==1){
					start_page = 1;
				}else{
					start_page = a + (4*(a-1));
				}
			}
		}
		
		int end_page = start_page + (view_rows - 1);
		
		/*int start_page = tpage - (tpage % view_rows) + 1;
		int end_page = start_page + (counts - 1);*/
		
		if(end_page > page_count) {
			end_page = page_count;
		}
		
		//등록한글이 10개가 넘으면
		if(start_page > view_rows) {
			str += "<a href='cmmtList?tpage=1&search="+search+"'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='cmmtList?tpage="+(start_page-1)+"&search=" +search+ "'>&lt;</a>&nbsp;&nbsp;";
		}
		
		for(int i = start_page; i <= end_page; i++) {
			if(i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>"; 
			} else {
				str += "<a href='cmmtList?tpage=" +i+"&search="+search+"'>["+i+"]</a>&nbsp;&nbsp;";
			}
		}
		
		if(page_count > end_page) {
			str += "<a href='cmmtList?tpage=" + (end_page + 1)
					+"&search="+search+"'> &gt;</a>&nbsp;&nbsp;";
			str += "<a href='cmmtList?tpage=" + page_count
					+"&search="+search+"'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		
		return str;
	}

}
