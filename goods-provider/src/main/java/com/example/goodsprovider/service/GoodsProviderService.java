package com.example.goodsprovider.service;

import com.example.goodscommons.pojo.player;

import java.util.List;

public interface GoodsProviderService {
    List<player> getPlayerList();

    player getPlayerDetail(Integer playerId);

    void addPlayer(player player);

}
