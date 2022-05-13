package com.example.goodsui.controller;

import com.example.goodscommons.pojo.player;
import com.example.goodscommons.vo.ResultVo;
import com.example.goodsui.service.GoodsUIService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ui")
public class GoodsUIController {

    @Resource
    private GoodsUIService goodsUIService;

    //测试goodsUI 调用goods-provider

    @RequestMapping("/test")
    public String test() {
        goodsUIService.testGoodsProvider();
        return "success";
    }

//    查询
    @RequestMapping("/list")
    public List<player> list(){
        List<player> playerlist = goodsUIService.getPlayerList();
        return playerlist;
    }

    //根据id进行查询
    @RequestMapping("/detail/{playerId}")
    public ResultVo detail(@PathVariable("playerId") Integer playerId){
        ResultVo player = goodsUIService.getPlayerDetail(playerId);
        return  player;
    }

    //添加
    @PostMapping("/add")
    public String add(@RequestBody player player){
        return goodsUIService.addPlayer(player);
    }



}
