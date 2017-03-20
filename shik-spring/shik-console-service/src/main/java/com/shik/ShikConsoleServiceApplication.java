package com.shik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShikConsoleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShikConsoleServiceApplication.class, args);
	}
}
