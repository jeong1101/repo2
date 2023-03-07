package com.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDate;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

public class server extends Thread {

	private static final Logger logger = Logger.getLogger(server.class);
	
	private Socket socket;
	public server (Socket socket) {
		this.socket=socket;
	} 
	String uuid = UUID.randomUUID().toString();
	LocalDate now = LocalDate.now();
	
	public void run() {
		BufferedReader br = null;
		PrintWriter pw = null;
		try {
			
			String connDSERVER_Ip  = socket.getInetAddress().getHostAddress();
			System.out.println(connDSERVER_Ip  + "에서 연결 시도.");
			
				//String DSERVER_IP = socket.getInetAddress().getHostAddress();
				//System.out.println("--- "+DSERVER_IP+"에서 연결 시도중---");
				
				// ip 체크 및 접근
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream());
				
				// 클라이언트에서 보낸 문자열 출력하기
				//System.out.println(br.readLine());
				
				//클라이언트에 문자열 전송
				pw.println("--- 수신 완료 ---");
				pw.flush();
				
				//로그 출력
				logger.info("[From "+ connDSERVER_Ip + "] " +now + " " +uuid);
				
			}catch (IOException e) {
				// TODO: handle exception
				logger.error(e);
			}finally {
				try {
					if(pw!=null) {pw.close();}
					if(br!=null) {br.close();}
					if(socket != null) {socket.close();}
				}catch (IOException e) {
					logger.error(e);
					
				}	

			}
	
	
	}
	
	
}
