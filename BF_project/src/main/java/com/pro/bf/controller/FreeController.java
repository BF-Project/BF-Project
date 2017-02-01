package com.pro.bf.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String qnaList(HttpServletRequest request, Model model) throws ServletException, IOException {
		
		String url = "free/freeList";
		
		ArrayList<FreeVO> freeList = null;
		
		model.addAttribute("freeList", freeList);
		
		return url;
	}
}
