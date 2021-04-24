package com.lingyi.service.impl;

import com.lingyi.dao.TeacherMapper;
import com.lingyi.entity.Teacher;
import com.lingyi.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> getAll() {
        return teacherMapper.selectAllTeacher();
    }

}
