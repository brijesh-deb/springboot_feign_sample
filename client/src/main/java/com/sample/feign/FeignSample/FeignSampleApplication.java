package com.sample.feign.FeignSample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignSampleApplication.class, args);
	}

}