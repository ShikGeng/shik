package com.shik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ShikRAserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShikRAserverApplication.class, args);
	}
}
