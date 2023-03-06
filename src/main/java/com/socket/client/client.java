package com.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

// Inet4Address.getLocalHost().getHostAddress()

public class client {
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	
	// 환경변수 설정
//	@Configuration
//	@PropertySources({
//		@PropertySource("classpath:properties/application.properties")
//	})
//	public class PropertyConfig{
//		
//	}
	String DSERVER_IP = System.getenv("DSERVER_IP");
	public client(String DSERVER_IP, int port) throws Exception {
		String uuid = UUID.randomUUID().toString();
		LocalDate now = LocalDate.now();

		
		while(true) {
		try {
			socket = new Socket(DSERVER_IP, port);
			System.out.println(socket.getInetAddress().getHostAddress() + "에 연결됨");
			
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream());
				
				pw.println(now + " " +uuid);
				pw.flush();
				
				System.out.println(br.readLine());
	 
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			//소켓 닫기
			try {
				if(socket != null) { socket.close(); }
				if(br != null) { br.close(); }
				if(pw != null) { pw.close(); }
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}	
		Thread.sleep(2000);
		}
		/*
			try {
				// 서버 요청
				socket = new Socket(DSERVER_IP, port);
				System.out.println(socket.getInetAddress().getHostAddress() + "에 연결됨");
				
				// 메세지 받기
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream());
				
				// 메세지 전달
				pw.println("--- 메세지 발송 ---");
				pw.flush();
				
				//응답 출력
				System.out.println(br.readLine());
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				//소켓 닫기
				try {
					if(socket != null) { socket.close(); }
					if(br != null) { br.close(); }
					if(pw != null) { pw.close(); }
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
			}	
		*/
	}
	
	
}
