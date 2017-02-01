package com.pro.bf.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pro.bf.dto.NoticeVO;
import com.pro.bf.serviceImpl.AdminServiceImpl;
import com.pro.bf.serviceImpl.NoticeServiceImpl;

@Controller
@RequestMapping("admin")
public class AdminMainController {

	@Autowired
	AdminServiceImpl adminService;
	@Autowired
	NoticeServiceImpl noticeService;
	
	@RequestMapping(value="start", method=RequestMethod.GET)
	public String goAdminPage(HttpServletRequest request, HttpSession session) throws SQLException{
		String url = "/admin/main";
		// 관리자 로그인한 아이디로 관리자 이름 가져오기
		String adminId = (String)session.getAttribute("loginAdmin");
		String adminName = adminService.adminName(adminId);
		session.setAttribute("adminName", adminName);
		return url;
	}
	
	@RequestMapping(value="exit")
	public String AdminPageOut(HttpSession session, HttpServletRequest request){
		session.removeAttribute("loginAdmin"); // 관리자 아이디로그인 정보 삭제
		session.removeAttribute("adminName");
		return "redirect:/start";
	}
	
	@RequestMapping("notice")
	public String noticeList(HttpServletRequest request) throws UnsupportedEncodingException, SQLException{
		request.setCharacterEncoding("UTF-8");
		String url = "admin/notice";
		// 공지사항 리스트
//		String search = request.getParameter("key"); // 아직 받는것은 없음 이후에 전체리스트와, 검색을 한번에 하기 위함
		String key = "";
		ArrayList<NoticeVO> noticeList = null;
		noticeList = noticeService.noticeList(key);
		System.out.println(noticeList);
		request.setAttribute("noticeList", noticeList); // 공지사항 리스트
		
		// 공지사항 개수
		int noticeListSize = 0;
		if(!(noticeList.size()==0))
			noticeListSize = noticeList.size();
		request.setAttribute("noticeListSize", noticeListSize); // 공지사항 개수
		
		// 페이지
		String page = ""; // 기본
		String currentPage = request.getParameter("page");
		if(currentPage==null || currentPage.equals("")){
			page="1";
			request.setAttribute("page", page); // 현재 페이지 : 기본값 1
		}else{
			request.setAttribute("page", currentPage); // 현재 페이지
		}
		return url;
	}
}