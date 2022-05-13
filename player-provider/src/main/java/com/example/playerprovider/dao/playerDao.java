package com.example.playerprovider.dao;


import com.example.goodscommons.pojo.player;
import com.example.goodscommons.vo.ResultVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public interface playerDao {
    List<player> getPlayerList();


    player add(@RequestBody player player);

    void deleteBatch(@Param("ids") Integer[] ids);

    void update(player player);

    player getPlayerById(Integer id);

    void delete(Integer id);
}
