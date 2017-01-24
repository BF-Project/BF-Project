package com.pro.bf.controller;

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

}
