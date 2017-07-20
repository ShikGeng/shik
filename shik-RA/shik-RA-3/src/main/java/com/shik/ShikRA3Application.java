package com.shik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ShikRA3Application {

	public static void main(String[] args) {
		SpringApplication.run(ShikRA3Application.class);
	}
}
