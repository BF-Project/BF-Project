package com.pro.bf.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pro.bf.dto.FreeVO;

public interface FreeService {

	ArrayList<FreeVO> freeList(String mbr_id) throws SQLException;
}
