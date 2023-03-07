package com.socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.log4j.Logger;

public class App {
	

	private static final int PORT_NUMBER = 4432;
	private static final Logger logger = Logger.getLogger(App.class);
	public static void main(String[] args) throws IOException, Exception{
		
		logger.info(":::                                                :::");
		logger.info(":::       Socket Application  Process Start        :::");
		logger.info(":::                                                :::");
		
		try(ServerSocket sv = new ServerSocket(PORT_NUMBER)){
			while(true) {
				Socket connection = sv.accept();
				Thread task = new server(connection);
				task.start();			
			}
		} catch (IOException e) {
			logger.error(e);	
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
