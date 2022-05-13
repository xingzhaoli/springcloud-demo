package com.example.playerui.controller;

import com.example.goodscommons.pojo.player;
import com.example.goodscommons.vo.ResultVo;
import com.example.playerui.feign.PlayerUIFeign;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerUIController {

    @Resource
    private PlayerUIFeign playerUIFeign;

//    查询所有顾客
    @RequestMapping("/list")
    public List<player> list(){
        List<player> playerList = playerUIFeign.getPlayerList();
        return playerList;
    }

//    根据id查看详情
    @RequestMapping("/detail/{id}")
    public ResultVo detail(@PathVariable("id") Integer id){
        return playerUIFeign.getPlayerDetail(id);
    }


}
