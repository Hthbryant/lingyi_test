package com.lingyi.service;

import com.lingyi.common.dto.BaseDTO;
import com.lingyi.entity.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getAll();

    BaseDTO createExcel();

}
