package com.pro.bf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="join")
public class JoinController {

	@RequestMapping(value="joinForm", method=RequestMethod.GET)
	public String JoinForm(){
		String url = "join/joinForm";
		return url;
	}
	
	@RequestMapping(value="joinjoinForm", method=RequestMethod.GET)
	public String JoinForm_Form(HttpServletRequest request){
		String url = "join/joinjoinForm";
		return url;
	}
}