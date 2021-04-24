package com.lingyi.service.impl;

import com.lingyi.common.dto.BaseDTO;
import com.lingyi.common.enums.SystemStatus;
import com.lingyi.common.utils.ExcelUtil;
import com.lingyi.dao.player.PlayerMapper;
import com.lingyi.entity.Player;
import com.lingyi.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerMapper playerMapper;

    @Override
    public List<Player> getAll() {
        return playerMapper.selectAllPlayer();
    }

    @Override
    public BaseDTO createExcel() {
        List<Player> list = playerMapper.selectAllPlayer();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String[] title = { "编号", "姓名", "年龄", "薪资" };
        Map<String, List<String>> playerMap = new HashMap<String, List<String>>();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<String> members = new ArrayList<>();
            members.add(list.get(i).getId()+"");
            members.add(list.get(i).getName());
            members.add(list.get(i).getAge() + "");
            members.add(list.get(i).getPrice() + "");
            playerMap.put(list.get(i).getId() + "", members);
        }
        String date = df.format(new Date());
        try {
            ExcelUtil.createExcel(playerMap,title,date);
        }catch (Exception e){
            log.error("create excel failure!");
            return new BaseDTO(SystemStatus.SYSTEM_ERROR);
        }

        return new BaseDTO(SystemStatus.SUCCESS);
    }

}
