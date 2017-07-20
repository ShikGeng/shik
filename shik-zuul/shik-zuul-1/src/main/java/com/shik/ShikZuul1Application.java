package com.shik;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ShikZuul1Application {

	public static void main(String[] args) {
		SpringApplication.run(ShikZuul1Application.class, args);
	}
}
