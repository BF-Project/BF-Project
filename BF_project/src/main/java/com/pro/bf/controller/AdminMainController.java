package com.pro.bf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("admin")
public class AdminMainController {

	@RequestMapping(value="start", method=RequestMethod.GET)
	public String goAdminPage(HttpServletRequest request){
		String url = "/admin/main";
		return url;
	}
}
