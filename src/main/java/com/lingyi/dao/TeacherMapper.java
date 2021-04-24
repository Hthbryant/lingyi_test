package com.lingyi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lingyi.entity.Man;
import com.lingyi.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper extends BaseMapper<Man> {
    List<Teacher> selectAllTeacher();
}
