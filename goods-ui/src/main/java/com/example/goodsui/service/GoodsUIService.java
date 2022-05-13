package com.example.goodsui.service;

import com.example.goodscommons.pojo.player;
import com.example.goodscommons.vo.ResultVo;

import java.util.List;

public interface GoodsUIService {

    void testGoodsProvider();

    List<player> getPlayerList();

    ResultVo getPlayerDetail(Integer playerId);

    String addPlayer(player player);
}
