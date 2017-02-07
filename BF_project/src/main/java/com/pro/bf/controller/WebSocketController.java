package com.pro.bf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {
	
	@RequestMapping("chat")
	public String chattingPage(){
		return "/chatting/chat-ws";
	}
}
