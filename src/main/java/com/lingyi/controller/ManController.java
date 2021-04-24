package com.lingyi.controller;

import com.lingyi.entity.Man;
import com.lingyi.service.ManService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        log.info("====this is info 级别日志====");
        log.warn("====this is warn 级别日志====");
        log.error("====this is error 级别日志====");
        log.debug("====this is debug 级别日志====");
        List<Man> men = manService.selectAll();
        System.out.println("man:"+men);
        return men;
    }

    @RequestMapping("/index")
    public String getTeacherIndex(){
        System.out.println("---man------");
        return "man/ManList";
    }
}
