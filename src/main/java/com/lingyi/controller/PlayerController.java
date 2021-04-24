package com.lingyi.controller;

import com.lingyi.common.dto.BaseDTO;
import com.lingyi.entity.Player;
import com.lingyi.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping("/get")
    @ResponseBody
    public List<Player> getHello(){
        System.out.println("---player get------");
        List<Player> playerList = playerService.getAll();
        System.out.println(playerList);
        return playerList;
    }

    @RequestMapping("/excel")
    @ResponseBody
    public BaseDTO createExcel(){
        System.out.println("---player create excel------");
        BaseDTO response = playerService.createExcel();
        System.out.println(response);
        return response;
    }

}
