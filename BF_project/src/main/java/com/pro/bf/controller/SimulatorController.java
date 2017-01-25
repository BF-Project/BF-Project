package com.pro.bf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="simulator")
public class SimulatorController {
	
	@RequestMapping(value="main")
	public String main(){
		String url = "simulator/main";
		return url;
	}
	
	@RequestMapping(value="control")
	public String control(String juso){
		String url = "simulator/control";
		System.out.println(juso);
		return url;
	}

}
