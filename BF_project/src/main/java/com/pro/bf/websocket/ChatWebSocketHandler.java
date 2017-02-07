package com.pro.bf.websocket;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatWebSocketHandler extends TextWebSocketHandler {
	private Map<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();
	
	// 접속시
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log("ID : "+session.getId()+" | IP : "+session.getRemoteAddress().getHostName()+" 연결 됨");		
		users.put(session.getId()+","+session.getRemoteAddress().getHostName(), session); // id와 ip주소를 session에 담는다
	}
	
	// 접속 해제시
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log("ID : "+session.getId()+" | IP : "+session.getRemoteAddress().getHostName()+" 연결 종료됨");
		users.remove(session.getId()+","+session.getRemoteAddress().getHostName()); // 담아놨던 id와 ip주소를 session에서 삭제
	}
	
	// 메시지 발신 | 수신
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log(session.getId() + "로부터 메시지 수신 : " + message.getPayload());
		
		// 아이디로 구분해야하는데
		// 관리자 session ==> loginAdmin
		// 접속회원 session ==> loginUser
		
		for(WebSocketSession s : users.values()){
			s.sendMessage(message);
			log(s.getId() + "에 메시지 발송 : " + message.getPayload());
		}
	}

	// 익셉션
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		log(session.getId() + "익셉션 발생 : " + exception.getMessage());
	}
	
	// 로그
	private void log(String logmsg){
		System.out.println(new Date() + " : " + logmsg);
	}
}