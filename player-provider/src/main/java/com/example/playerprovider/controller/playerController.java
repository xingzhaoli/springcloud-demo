package com.example.playerprovider.controller;

import com.example.goodscommons.pojo.player;
import com.example.goodscommons.vo.ResultVo;
import com.example.playerprovider.dao.playerDao;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/player")
public class playerController {

    @Resource
    private playerDao playerDao;

    @RequestMapping("/list")
    public List<player> list(){
    return playerDao.getPlayerList();
    }

    @RequestMapping("/detail")
    public ResultVo detail(@RequestParam("id")Integer id) throws InterruptedException {
        Thread.sleep(3000);
        player player = playerDao.getPlayerById(id);
        return ResultVo.ok(player);
    }


}
