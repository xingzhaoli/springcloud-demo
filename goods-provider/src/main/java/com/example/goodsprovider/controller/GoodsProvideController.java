package com.example.goodsprovider.controller;

import com.example.goodscommons.pojo.player;
import com.example.goodsprovider.service.GoodsProviderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/provider")
public class GoodsProvideController {

    @Resource
    private GoodsProviderService goodsProviderService;

    @RequestMapping("/test")
    public String test(){
        System.out.println("进入了goods-provider");
        return "调用成功";
    }

//    返回所有图书
    @RequestMapping("/list")
    public List<player> getPlayerList(){
       List<player> playerList = goodsProviderService.getPlayerList();
        return playerList;
    }

    //查询图书
    @RequestMapping("/datail/{playerId}")
    public player detail(@PathVariable("playerId") Integer playerId) throws InterruptedException {
        Thread.sleep(3000);
        player player = goodsProviderService.getPlayerDetail(playerId);
        return player;
    }

    //添加图书
    @PostMapping("/add")
    public String add(@RequestBody player player){
        goodsProviderService.addPlayer(player);
        return "success";
    }

    @HystrixCommand(fallbackMethod = "fallBack" ,commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")
    })

    @RequestMapping("/test_hystrix")
    public String testHystrix(@RequestParam("num") Integer num){
        int n = (int) Math.floor(Math.random()*100);
        int result = n/num;
        return "服务正常返回："+n+"/"+num +"=" + result;

    }

    public String fallBack(@RequestParam("num") Integer num){
        return "服务降级响应：num为0";
    }

}
