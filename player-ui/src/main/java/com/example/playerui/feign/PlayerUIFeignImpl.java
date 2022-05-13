package com.example.playerui.feign;

import com.example.goodscommons.pojo.player;
import com.example.goodscommons.vo.ResultVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerUIFeignImpl implements PlayerUIFeign{
    @Override
    public List<player> getPlayerList() {
        return null;
    }

    @Override
    public ResultVo getPlayerDetail(Integer id) {
        return ResultVo.error("feign的服务降级响应");
    }
}
