package com.lingyi.controller;

import com.lingyi.entity.Teacher;
import com.lingyi.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/get")
    @ResponseBody
    public List<Teacher> getTeacher(){
        System.out.println("---teacher------");
        List<Teacher> teacherList = teacherService.getAll();
        System.out.println(teacherList);
        return teacherList;
    }

    @RequestMapping("/index")
    public String getTeacherIndex(){
        System.out.println("---teacher------");
        List<Teacher> teacherList = teacherService.getAll();
        System.out.println(teacherList);
        return "Teacher";
    }

}
