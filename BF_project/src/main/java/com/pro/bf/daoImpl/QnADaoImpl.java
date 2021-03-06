package com.pro.bf.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.pro.bf.dao.QnADao;
import com.pro.bf.dto.QnAVO;

public class QnADaoImpl implements QnADao {

	private SqlMapClient client;
	static int view_rows = 10; // 페이지의 개수
	static int counts = 10; // 한 페이지에 나타낼 게시글 개수
	
	
	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public ArrayList<QnAVO> listQna(String mbr_id) throws SQLException {
		ArrayList<QnAVO> qnaList = new ArrayList<QnAVO>();
		qnaList = (ArrayList<QnAVO>) client.queryForList("listQna", mbr_id);
		return qnaList;
	}

	@Override
	public ArrayList<QnAVO> listAllQna(int tpage,String search) throws SQLException {
		ArrayList<QnAVO> qnaList = new ArrayList<QnAVO>();
		
		if(search.equals("")){ // 검색어가 없을경우
			search = "%";
		}
		int startRow = -1;
		int endRow = -1;
		
		int totalRecord = totalQna(search);
		
		startRow = (tpage - 1) * counts ;
		endRow = startRow + counts - 1;
		if (endRow > totalRecord)
			endRow = totalRecord;
		
		qnaList = (ArrayList<QnAVO>) client.queryForList("listAllQna", search, startRow, counts);
		return qnaList;
	}

	@Override
	public QnAVO getQna(int qna_num) throws SQLException {
		QnAVO qnaVO = (QnAVO) client.queryForObject("getQna", qna_num);
		countQna(qnaVO);
		qnaVO.setQna_cnt(qnaVO.getQna_cnt() + 1);
		return qnaVO;
	}

	@Override
	public void insertQna(QnAVO qnaVO) throws SQLException {
		client.insert("insertQna", qnaVO);
	}

	@Override
	public int updateQna(QnAVO qnaVO) throws SQLException {
		int result = client.update("updateQna", qnaVO);
		return result;
	}

	@Override
	public int countQna(QnAVO qnaVO) throws SQLException {
		client.update("countQna", qnaVO);
		return 0;
	}

	@Override
	public int totalQna(String search) throws SQLException {
		int total_pages = 0;
		total_pages = (Integer) client.queryForObject("totalQna", search);
		return total_pages;
	}

	//삭제
	@Override
	public void deleteQna(int qna_num) throws SQLException {
		client.delete("deleteQna",qna_num);		
		
	
	}

	@Override
	public QnAVO SearchQnaVo(int qna_num) throws SQLException {
		QnAVO qnavo = (QnAVO) client.queryForObject("SearchQnaVo", qna_num);
		return qnavo;
		
	}
}