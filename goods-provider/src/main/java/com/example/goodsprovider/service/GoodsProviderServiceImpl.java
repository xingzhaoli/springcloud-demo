package com.example.goodsprovider.service;

import com.example.goodscommons.pojo.player;
import com.example.goodsprovider.dao.GoodsDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsProviderServiceImpl implements GoodsProviderService{

    @Resource
    private GoodsDao goodsDao;


    @Override
    public List<player> getPlayerList() {
        return goodsDao.getPlayerList();
    }

    @Override
    public player getPlayerDetail(Integer playerId) {
        return goodsDao.getPlayerDetail(playerId);
    }

    @Override
    public void addPlayer(player player) {
        goodsDao.addPlayer(player);
    }

}
