package com.pro.bf.daoImpl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.pro.bf.dao.CmtDao;
import com.pro.bf.dto.CmtVO;

public class CmtDaoImpl implements CmtDao {

	private SqlMapClient client;

	public void setClient(SqlMapClient client) {
		this.client = client;
	}

	@Override
	public List<CmtVO> cmtAllList(int cmt_num) throws SQLException {
		List<CmtVO> cmtAllList = client.queryForList("cmtList", cmt_num);
		return cmtAllList;
	}

	@Override
	public void intsertCmt(CmtVO cmtVO) throws SQLException {
		client.insert("insertCmt", cmtVO);
	}

	// 댓글 삭제
	@Override
	public int deleteCmt(int cmt_num) throws SQLException {
		int result = client.delete("deleteCmt", cmt_num);
		return result;
	}

}
