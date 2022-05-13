package com.example.playerui.feign;

import com.example.goodscommons.pojo.player;
import com.example.goodscommons.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "player-provider",fallback = PlayerUIFeignImpl.class)
public interface PlayerUIFeign {

    @GetMapping("/player/list")
    List<player> getPlayerList();

    @GetMapping("/player/detail")
    ResultVo getPlayerDetail(@RequestParam("id") Integer id);

}

