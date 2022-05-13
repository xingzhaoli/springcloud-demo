package com.example.goodsui.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    //rebbon调用 使用的是resttemplate对象
    @Bean
    @LoadBalanced//负载均衡设置
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
