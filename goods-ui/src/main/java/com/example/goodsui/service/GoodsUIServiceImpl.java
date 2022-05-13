package com.example.goodsui.service;

import com.example.goodscommons.pojo.player;
import com.example.goodscommons.vo.ResultVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class GoodsUIServiceImpl implements GoodsUIService{

    @Resource
    private RestTemplate restTemplate;

    @Override
    public void testGoodsProvider() {
        String forObject = restTemplate.getForObject("http://goods-provider/provider/test", String.class);
        System.out.println("goods-provider返回的结果："+forObject);

    }

    @Override
    public List<player> getPlayerList() {
        player[] playerList = restTemplate.getForObject("http://goods-provider/provider/list", player[].class);
        return Arrays.asList(playerList);
    }

    @Override
    @HystrixCommand(
            fallbackMethod = "fallBackPlayerDetail",commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    }//降级响应设置的时间
    )
    public ResultVo getPlayerDetail(Integer playerId) {
        player player = restTemplate.getForObject("http://goods-provider/provider/datail/" + playerId, player.class);
        return ResultVo.ok(player);
    }

    public ResultVo fallBackPlayerDetail(Integer playerId) {
        return ResultVo.error("服务降级返回的响应内容");
    }

    @Override
    public String addPlayer(player player) {
        String msg = restTemplate.postForObject("http://goods-provider/provider/add",player,String.class);
        return msg;
    }

}
