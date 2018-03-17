package com.zking.xm.biz.impl;

import com.zking.xm.biz.ISatiBiz;
import com.zking.xm.mapper.SatisfyMapper;
import com.zking.xm.model.Satisfy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SatiBizImpl implements ISatiBiz {

    @Autowired
    private SatisfyMapper satisfyMapper;

    @Override
    public List<Integer> listCount(Satisfy satisfy) {
        return satisfyMapper.count(satisfy);
    }

}
