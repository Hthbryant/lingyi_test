package com.lingyi.dao.man;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lingyi.entity.Man;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManMapper extends BaseMapper<Man> {
    List<Man> selectAllPlayer();
}
