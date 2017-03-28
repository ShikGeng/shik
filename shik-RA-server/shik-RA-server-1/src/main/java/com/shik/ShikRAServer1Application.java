package com.shik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ShikRAServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(ShikRAServer1Application.class);
	}
}
