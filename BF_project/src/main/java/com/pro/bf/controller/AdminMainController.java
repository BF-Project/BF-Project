package com.pro.bf.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String noticeList(HttpServletRequest request, Model model) throws UnsupportedEncodingException, SQLException{
		request.setCharacterEncoding("UTF-8");
		String url = "admin/notice/notice";
		
		// 공지사항 리스트 or 검색
		String search = request.getParameter("search"); // 공지사항 검색, null 일경우 전체리스트 가져옴 | 초기값은 null 
		if(search==null || search.equals(""))
			search="";
		request.setAttribute("search", search);
		
		// 현재 페이지
		String page = request.getParameter("page"); // 처음에는 page의 값이 null 
		if(page==null || page.equals(""))
			page="1";
		model.addAttribute("page",page);
		
		// 페이지 이동
		String paging = null; // 처음 접속했을땐 null
		
		
		// Service, dao, db
		ArrayList<NoticeVO> noticeList = null;
		noticeList = noticeService.noticeList(Integer.parseInt(page), search); // 공지사항 리스트(검색/검색안할때)
		paging = noticeService.pageNumber(Integer.parseInt(page), search);
		
		int noticeListSize = 0;
		if(!(noticeList.size()==0))
			noticeListSize = noticeList.size();
		request.setAttribute("noticeListSize", noticeListSize); // 공지사항 개수
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("paging", paging);
		
		return url;
	}
	
	@RequestMapping("write")
	public String writeNotice(HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		String url = "admin/notice/writeNotice";
		String page = request.getParameter("page");
		request.setAttribute("page", page);
		return url;
	}
	
	@RequestMapping("InsertNotice")
	@ResponseBody
	public String insertNotice(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException, SQLException{
		request.setCharacterEncoding("UTF-8");
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
		String admin = (String)session.getAttribute("loginAdmin");
		
		NoticeVO noticeVo = new NoticeVO();
		noticeVo.setNotice_title(noticeTitle);
		noticeVo.setNotice_content(noticeContent);
		noticeVo.setAdmin_id(admin);
		noticeService.insertNotice(noticeVo);
		return null;
	}
}