package com.pro.bf.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.pro.bf.dao.FreeDao;
import com.pro.bf.dto.FreeVO;

public class FreeDaoImpl implements FreeDao{

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client = client;
	}
	@Override
	public ArrayList<FreeVO> freeList(String mbr_id) throws SQLException {
		ArrayList<FreeVO> freeList = (ArrayList<FreeVO>) client.queryForList("freeList", mbr_id);
		return freeList;
	}
	
}
