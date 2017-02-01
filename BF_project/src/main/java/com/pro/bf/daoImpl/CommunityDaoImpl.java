package com.pro.bf.daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.pro.bf.dao.CommunityDao;
import com.pro.bf.dto.CommunityVO;

public class CommunityDaoImpl implements CommunityDao{

	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client = client;
	}
	@Override
	public ArrayList<CommunityVO> listCmmt(String mbr_id, String admin_id)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<CommunityVO> listAllCmmt(int tpage) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CommunityVO getCmmt(int cmmt_num) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insertCmmt(CommunityVO cmmtVO) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int updateCmmt(CommunityVO cmmtVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int countCmmt(CommunityVO cmmtVO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int totalCmmt() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void deleteCmmt(int Cmmt_num) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
}
