package com.lingyi.controller;

import com.lingyi.entity.Man;
import com.lingyi.service.ManService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/man")
public class ManController {

    private static final Logger log = LoggerFactory.getLogger(ManController.class);

    @Autowired
    private ManService manService;

    @RequestMapping("/get")
    @ResponseBody
    public List<Man> getAll(){
        List<Man> manList = manService.selectAll();
        log.info("manList:{}",manList);
        return manList;
    }

    @RequestMapping("/index")
    public String getTeacherIndex(HttpServletRequest request, HttpServletResponse response
                                  ){
        List<Man> manList = manService.selectAll();
        log.info("manList:{}",manList);
        request.setAttribute("manList",manList);
        return "man/ManList";
    }
}
