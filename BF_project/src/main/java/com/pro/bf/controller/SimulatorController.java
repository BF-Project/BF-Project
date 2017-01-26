package com.pro.bf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="simulator")
public class SimulatorController {
	
	@RequestMapping(value="main",method=RequestMethod.GET)
	public String mainGet(){
		String url = "simulator/main";
		return url;
	}
	
	@RequestMapping(value="control")
	public String control(String juso){
		String url = "simulator/control";
		System.out.println(juso);
		return url;
	}
	
	@RequestMapping(value="start",method=RequestMethod.POST)
	public void start(String radio, String sel, String addr){
		System.out.println(radio);
		System.out.println(addr);
		System.out.println(sel);
	}

}
