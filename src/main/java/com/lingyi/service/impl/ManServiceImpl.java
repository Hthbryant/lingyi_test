package com.lingyi.service.impl;

import com.lingyi.dao.man.ManMapper;
import com.lingyi.entity.Man;
import com.lingyi.service.ManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManServiceImpl implements ManService {

    @Autowired
    private ManMapper manMapper;

    @Override
    public List<Man> selectAll() {
        return manMapper.selectAllPlayer();
    }
}
