package com.pro.bf.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.pro.bf.dao.QnADao;
import com.pro.bf.daoImpl.QnADaoImpl;
import com.pro.bf.dto.QnAVO;
import com.pro.bf.service.QnAService;

@Service
public class QnAServiceImpl implements QnAService{

	@Autowired
	QnADao qnaDao;
	
	@Autowired
	QnADaoImpl qnaDaoImpl;
	
	private SqlMapClient client;
	static int view_rows = 10; // 페이지의 개수
	static int counts = 10; // 한 페이지에 나타낼 게시글 개수
	
	public void setClient(SqlMapClient client) {
		this.client = client;
	}
	
	public void setQnaDao(QnADao qnaDao) {
		this.qnaDao = qnaDao;
	}
	
	public void setQnaDaoImpl(QnADaoImpl qnaDaoImpl) {
		this.qnaDaoImpl = qnaDaoImpl;
	}

	@Override
	public ArrayList<QnAVO> getQnaList(int tpage) throws SQLException {
		ArrayList<QnAVO> qnaList = qnaDao.listAllQna(tpage);
		return qnaList;
	}

	@Override
	public QnAVO getQnaDetail(String qna_num) throws SQLException {
		QnAVO qnaVO = qnaDao.getQna(Integer.parseInt(qna_num));
		return qnaVO;
	}

	@Override
	public int updateQna(QnAVO qnaVO) throws SQLException {
		int result = qnaDao.updateQna(qnaVO);
		return result;
	}

	@Override
	public void insertQna(QnAVO qnaVO) throws SQLException {
		/*qnaVO.setMbr_id(session_id);*/
		qnaDao.insertQna(qnaVO);
		
	}

	@Override
	public int countQna(QnAVO qnaVO) throws SQLException {
		qnaDao.countQna(qnaVO);
		return 0;
	}

	@Override
	public String pageNumber(int tpage) throws SQLException {
		String str = "";
		
		int total_pages = qnaDaoImpl.totalQna();
		int page_count = total_pages / counts + 1;
		
		if(total_pages % counts == 0) {
			page_count--;
		}
		
		if(tpage < 1) {
			tpage = 1;
		}
		
		int start_page = tpage - (tpage % view_rows) + 1;
		int end_page = start_page + (counts - 1);
		
		if(end_page > page_count) {
			end_page = page_count;
		}
		
		if(start_page > view_rows) {
			str += "<a href='qnaList?tpage=1'>&lt;&lt;</a>&nbsp;&nbsp;";
			str += "<a href='qnaList?tpage=" + (start_page - 1);
		}
		
		for(int i = start_page; i <= end_page; i++) {
			if(i == tpage) {
				str += "<font color=red>[" + i + "]&nbsp;&nbsp;</font>"; 
			} else {
				str += "<a href='qnaList?tpage=" + i +"'>[" + i + "]</a>&nbsp;&nbsp;";
			}
		}
		
		if(page_count > end_page) {
			str += "<a href='qnaList?tpage=" + (end_page + 1)
					+"'> &gt; </a>&nbsp;&nbsp;";
			str += "<a href='qnaList?tpage=" + page_count
					+"'> &gt; &gt; </a>&nbsp;&nbsp;";
		}
		
		return str;
	}

	
	


}
