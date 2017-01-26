package com.pro.bf.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.bf.dto.AddrVO;
import com.pro.bf.dto.MbrVO;
import com.pro.bf.serviceImpl.AddrServiceImpl;
import com.pro.bf.serviceImpl.MbrServiceImpl;

@Controller
@RequestMapping(value="join")
public class JoinController {
	
	@Autowired
	AddrServiceImpl addrService;
	
	@Resource(name="mbrServiceImpl")
	MbrServiceImpl mbrService;
	
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
	public String joinForm_Form2(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException{
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
		}
		String url = "redirect:/start";
		
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
		
		MbrVO mbrVo = new MbrVO();
		mbrVo.setMbr_id(id);
		mbrVo.setMbr_pwd(pwd);
		mbrVo.setMbr_nm(name);
		mbrVo.setMbr_phone(number);
		mbrVo.setMbr_eml(email);
		mbrVo.setMbr_addr(addr1 +" "+addr2);
			Date mbr_brt = null;
			try {
				mbr_brt = new SimpleDateFormat("yyyyMMdd").parse(birth);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		mbrVo.setMbr_brt(mbr_brt);
		mbrVo.setMbr_gnd(gender);
		mbrVo.setMbr_eml_yn(emailyn);
		mbrService.insertMember(mbrVo);
		// 
		
		String joinSuccess = "joinSuccess";
		request.setAttribute("joinSuccess", joinSuccess);
		session.setAttribute("joinSuccess", joinSuccess);
		return url;
	}
	
	@RequestMapping("findZipNum")
	public String findZipNum(@RequestParam(value="dong",defaultValue="서초")String dong,
								HttpServletRequest request, HttpServletResponse response, Model model)
								throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		String url = "join/findZipNum";
		ArrayList<AddrVO> addressList=addrService.getFindZipNum(dong);
		model.addAttribute("addressList",addressList);
		return url;
	}
	
	@RequestMapping("idcheck")
	@ResponseBody // Ajax에 리턴할 값을 주기위해 사용한다. SJON 형식의 값을 응답할때 유용함. JACKSON으로 인해 문자열로 변환된다.
	public String idcheck(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String userid = request.getParameter("userid");
		String result = mbrService.idCheck(userid);
		System.out.println("4 리턴받은 아이디 값(Controller) " + result);
		String data = "";
		if(result == null){
			data = "yes";
		}else{
			data = "no";
		}
		System.out.println("5 결과 " + data);
//		return null;
		return data; // 그냥 문자열로 리턴하면 WEB-INF/views/data.jsp로 가게되는 꼴... ResponseBody를 사용한다.(Spring에서)
	}
	
	@RequestMapping("login")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws SQLException{
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MbrVO mbrVo = new MbrVO();
		mbrVo.setMbr_id(id);
		mbrVo.setMbr_pwd(pwd);
		String login = mbrService.login(mbrVo);
		String data;
		if(!(login==null)){
			data = "yes";
			// 로그인 했을시 세션에 로그인한 id를 세션에 저장
			session.setAttribute("loginUser", login);			
			// 로그인한 회원 이름 찾기
			String loginUserName = mbrService.searchUserName(login);
			session.setAttribute("loginUserName", loginUserName);
			System.out.println(session.getAttribute("loginUser"));
			System.out.println(session.getAttribute("loginUserName"));
		}else{
			data = "no";
		}
		return data;
	}
}