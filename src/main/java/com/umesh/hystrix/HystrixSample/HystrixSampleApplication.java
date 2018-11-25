package com.umesh.hystrix.HystrixSample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixSampleApplication.class, args);
	}
}
