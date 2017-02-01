package com.pro.bf.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pro.bf.dto.FreeVO;
import com.pro.bf.serviceImpl.FreeServiceImpl;

@Controller
@RequestMapping("/free")
public class FreeController {

	@Autowired
	FreeServiceImpl freeServiceImpl;	
		
	public void setFreeServiceImpl(FreeServiceImpl freeServiceImpl) {
		this.freeServiceImpl = freeServiceImpl;
	}

	@RequestMapping("/freeList")
	public String freeList(HttpServletRequest request, Model model) throws ServletException, IOException, SQLException {
		
		String url = "free/freeList";
		
		ArrayList<FreeVO> freeList = freeServiceImpl.freeList("test");
		
		model.addAttribute("freeList", freeList);
		
		return url;
	}
	
	@RequestMapping("freeWrite")
	public String freeWrite(HttpSession session) throws ServletException, IOException {
		String url = "free/freeWrite";
		String loginUser = (String) session.getAttribute("loginUser");
		return url;
	}
	
	@RequestMapping(value="/freeWriteForm", method=RequestMethod.POST)
	public String freeWriteForm(@RequestParam("fre_title") String fre_title,
			@RequestParam("fre_content") String fre_content, HttpSession session)
			throws ServletException, IOException, SQLException {
		String url = "redirect:freeList";
		
		String loginUser = (String) session.getAttribute("loginUser");
		
		FreeVO freeVO = new FreeVO();
		freeVO.setFre_title(fre_title);
		freeVO.setFre_content(fre_content);
		freeVO.setMbr_id(loginUser);
		
		freeServiceImpl.insertFree(freeVO);
		
		return url;
	}
}
