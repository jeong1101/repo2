package com.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class App {
	

	private static final int PORT_NUMBER = 4432;

	public static void main(String[] args) throws IOException, Exception{
		
		System.out.println(":::                                                :::");
		System.out.println(":::       Socket Application  Process Start        :::");
		System.out.println(":::                                                :::");
		
		try(ServerSocket sv = new ServerSocket(PORT_NUMBER)){
			while(true) {
				Socket connection = sv.accept();
				Thread task = new server(connection);
				task.start();			
			}
		} catch (IOException e) {
			System.out.println(e);	
		}
				
	/*      while(true){		// 무한반복
			// 코드 실행
		    ...
		    ...
		    
		    
		    Thread.sleep(1000);	// 1초 후 다시 while문 실행되도록 sleep 처리
		}
	*/
		
		
	}
	
	
}
