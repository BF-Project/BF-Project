package com.pro.bf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="join")
public class JoinController {

	@RequestMapping(value="joinForm", method=RequestMethod.GET)
	public String JoinForm(){
		String url = "join/joinForm";
		return url;
	}
	
	@RequestMapping(value="joinjoinForm", method=RequestMethod.GET)
	public String JoinForm_Form(@RequestParam(value="email", defaultValue="Y")String email, HttpSession session){
		session.setAttribute("email", email);
		String url = "join/joinjoinForm";
		return url;
	}
	
	@RequestMapping(value="joinjoinForm", method=RequestMethod.POST)
	public String joinForm_Form2(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		String url = "";
		String id = request.getParameter("InputId"); // 아이디
		String pwd = request.getParameter("InputPassword1"); // 패스워드
		String name = request.getParameter("username"); // 이름
		String number = request.getParameter("usernumber"); // 전화번호
		String email = request.getParameter("InputEmail"); // 이메일
		String addr1 = request.getParameter("InputAddr1"); // 주소 1(검색)
		String addr2 = request.getParameter("InputAddr2"); // 주소 2(입력)
		String birth = request.getParameter("InputBirth"); // 생년월일
		String gender = request.getParameter("gender"); // 성별
		String emailyn = (String)session.getAttribute("email"); // 이메일 수신여부
		
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(name);
		System.out.println(number);
		System.out.println(email);
		System.out.println(addr1);
		System.out.println(addr2);
		System.out.println(birth);
		System.out.println(gender);
		System.out.println(emailyn);
		
		
		return url;
	}
}