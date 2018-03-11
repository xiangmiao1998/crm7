package com.zking.xm.biz.impl;

import com.zking.util.PageBean;
import com.zking.xm.biz.ISaleBiz;
import com.zking.xm.mapper.SalChanceXmMapper;
import com.zking.xm.model.SalChanceXm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleBizImpl implements ISaleBiz {

    @Autowired
    private SalChanceXmMapper salChanceXmMapper;

    @Override
    public int add(SalChanceXm salChanceXm) {
        return salChanceXmMapper.insertSelective(salChanceXm);
    }

    @Override
    public List<SalChanceXm> list(SalChanceXm salChanceXm, PageBean pageBean) {
        return salChanceXmMapper.list(salChanceXm);
    }

    @Override
    public int del(SalChanceXm salChanceXm) {
        return salChanceXmMapper.deleteByPrimaryKey(salChanceXm.getChcId());
    }

    @Override
    public int edit(SalChanceXm salChanceXm) {
        return salChanceXmMapper.updateByPrimaryKeySelective(salChanceXm);
    }

    @Override
    public SalChanceXm load(SalChanceXm salChanceXm) {
        return salChanceXmMapper.selectByPrimaryKey(salChanceXm.getChcId());
    }
}
