package com.example.goodsprovider.dao;

import com.example.goodscommons.pojo.player;

import java.util.List;

public interface GoodsDao {
    List<player> getPlayerList();

    player getPlayerDetail(Integer playerId);

    void addPlayer(player player);

}
