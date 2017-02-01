/*package com.pro.bf.controller;

import java.awt.color.CMMException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pro.bf.dao.CommunityDao;
import com.pro.bf.dto.CommunityVO;
import com.pro.bf.serviceImpl.CmtServiceImpl;
import com.pro.bf.serviceImpl.CommunityServiceImpl;
import com.pro.bf.serviceImpl.MbrServiceImpl;

//controller 설정
//Requestmapping 설정

@Controller
@RequestMapping("/cmmt")
public class CommunityController {
	
	//@Autowired설정
	@Autowired(required=false)
	CommunityServiceImpl cmmtServiceImpl;
	
	@Autowired(required=false)
	MbrServiceImpl mbrServiceImpl;
	
	@Autowired(required=false)
	CommunityDao cmmtDao;
	
	//set설정
	public void setCmmtServiceImpl(CommunityServiceImpl cmmtServiceImpl) {
		this.cmmtServiceImpl = cmmtServiceImpl;
	}

	public void setMbrServiceImpl(MbrServiceImpl mbrServiceImpl) {
		this.mbrServiceImpl = mbrServiceImpl;
	}

	public void setCmtDao(CommunityDao cmmtDao) {
		this.cmmtDao = cmmtDao;
	}

	//listmapping설정
	@RequestMapping("cmmt/cmmtList")
	public String cmtList(HttpServletRequest request,HttpSession session,Model model)
	throws ServletException,IOException{
		
		String url="cmmt/cmmtList";
		
		//페이징처리(전체페이지변수)
		String tpage =request.getParameter("tpage");
		
		if(tpage==null){
			tpage="1";
		}else if(tpage.equals("")){
			tpage="1";
		}
		model.addAttribute("tpage",tpage);
		
		//페이징처리 배열설정 (초기변수)
		ArrayList<CommunityVO> cmmtList=null;
		String paging =null;
		try{
			cmmtList=cmmtServiceImpl.getCmmtList(Integer.parseInt(tpage));
			paging=cmmtServiceImpl.pageNumber(Integer.parseInt(tpage));
			
			for(CommunityVO VO : cmmtList){
				System.out.println(VO.getCmmt_content());
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		///////////////////페이징처리
		model.addAttribute("cmtList",cmmtList);
		int n=cmmtList.size();
		model.addAttribute("cmtListSize",n);
		model.addAttribute("paging",paging);
		
		return url;
	}
	
	//delete mapping 설정
	@RequestMapping("/delete")
	public String deleteCmt(
			@RequestParam("cmmt_num")int cmmt_num)
			throws ServletException,IOException{
		
		String url="redirect:cmmtList";
		
		try{
			cmmtDao.deleteCmmt(cmmt_num);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return url;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
*/