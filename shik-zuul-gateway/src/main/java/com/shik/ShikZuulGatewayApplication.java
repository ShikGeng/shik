package com.shik;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ShikZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShikZuulGatewayApplication.class, args);
	}
}
