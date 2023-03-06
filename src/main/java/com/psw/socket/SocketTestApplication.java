package com.psw.socket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:/application.properties")
@SpringBootApplication
@Configuration
public class SocketTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocketTestApplication.class, args);
	}

}
