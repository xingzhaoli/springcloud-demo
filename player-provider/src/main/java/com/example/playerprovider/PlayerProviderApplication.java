package com.example.playerprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.example.playerprovider.dao")
public class PlayerProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayerProviderApplication.class, args);
    }

}
