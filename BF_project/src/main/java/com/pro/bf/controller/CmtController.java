package com.pro.bf.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.bf.dto.CmtVO;
import com.pro.bf.serviceImpl.CmtServiceImpl;

@Controller
@RequestMapping("/cmt")
public class CmtController {

	@Autowired
	CmtServiceImpl CmtServiceImpl;
	
	
	@RequestMapping(value="/cmtList", method=RequestMethod.POST)
	@ResponseBody
	public List<CmtVO> cmtList(@RequestBody Map<String, Object> jsonMap, Model model,HttpServletResponse response) {
		List<CmtVO> cmtList = new ArrayList<CmtVO>();
		String cmt_num = (String) jsonMap.get("fre_num");		
		try {
			cmtList = CmtServiceImpl.cmtAllList(Integer.parseInt(cmt_num));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*List<CmtVO> tempList=new ArrayList<CmtVO>();
		CmtVO cmt=new CmtVO();
		cmt.setMbr_id("test");
		cmt.setCmt_date(new Date(2017,2,3));
		cmt.setCmt_content("어쩌구 저쩌구");
		tempList.add(cmt);*/
		return cmtList;
	}
}
