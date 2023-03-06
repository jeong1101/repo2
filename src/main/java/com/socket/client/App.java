package com.socket.client;

import java.net.Inet4Address;
import java.util.Map;

import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.annotation.Resource;

@Controller
@PropertySource("classpath:properties/application.properties")
@Component
public class App {
//	// 환경변수 설정
//	@Configuration
//	@PropertySources({
//		@PropertySource("classpath:properties/application.properties")
//	})
//	public class PropertyConfig{
//		
//	}


	//여기서부터 작동해랑
	
	public static void main(String[] args) throws Exception {
		//String DSERVER_IP = PropertySource("classpath:properties/application.properties");
		String myIp = Inet4Address.getLocalHost().getHostAddress() ;
		
//		Map<String, String> env = System.getenv();
//        for (String envName: env.keySet()) {
//            System.out.println(envName + ":" + env.get(envName));
//        }
        
		String DSERVER_IP = System.getenv("DSERVER_IP");
		
		System.out.println("my ip = " + myIp);
		System.out.println("server ip = " + DSERVER_IP);
		

		
		int port = 4432;
		new client(DSERVER_IP, port);
		}
	
//	private static String PropertySource(String string) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	


	//여기까지
	

	
//	@Value("${DSERVER_IP}")
//	private static String DSERVER_IP;
//	 public static void main( String[] args ) throws Exception {
//		 
//		 System.out.println("server ip = " + DSERVER_IP1);
//	        int port = 4432;
//			new client(DSERVER_IP1, port);
//			
//	    }
		
	
}
