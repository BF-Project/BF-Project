package com.pro.bf.daoImpl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.pro.bf.dao.TouristDao;

public class TouristDaoImpl implements TouristDao{

//	private static TouristDaoImpl instance = new TouristDaoImpl();
//	private TouristDaoImpl(){}
//	public static TouristDaoImpl getInstance(){
//		return instance;
//	}
//	private SqlMapClient client = IBatisDBConnector.getSqlMapInstance();
	
	private SqlMapClient client;
	public void setClient(SqlMapClient client){
		this.client = client;
	}
}
