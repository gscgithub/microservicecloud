package com.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DeptComsumer_DashBoard_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptComsumer_DashBoard_App.class, args);
    }
}
