package com.shik;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ShikZuulGateway3Application {

	public static void main(String[] args) {
		SpringApplication.run(ShikZuulGateway3Application.class, args);
	}
}
