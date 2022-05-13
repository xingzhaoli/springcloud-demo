package com.example.deshboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard//开启仪表盘
public class DeshboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeshboardApplication.class, args);
    }

}
