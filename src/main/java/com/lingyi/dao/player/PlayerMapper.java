package com.lingyi.dao.player;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lingyi.entity.Player;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlayerMapper extends BaseMapper<Player> {

    List<Player> selectAllPlayer();

}
