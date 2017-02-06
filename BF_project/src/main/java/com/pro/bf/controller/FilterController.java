package com.pro.bf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FilterController {

	@RequestMapping("filter")
	public String FilterCont(HttpServletRequest request, HttpServletResponse response){
		System.out.println("필터 컨트롤러 ^^");
		return "/start";
	}
}
