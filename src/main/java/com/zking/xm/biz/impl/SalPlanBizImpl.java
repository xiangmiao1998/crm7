package com.zking.xm.biz.impl;

import com.zking.util.PageBean;
import com.zking.xm.biz.ISalPlanBiz;
import com.zking.xm.mapper.SalPlanXmMapper;
import com.zking.xm.model.SalPlanXm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalPlanBizImpl implements ISalPlanBiz {

    @Autowired
    private SalPlanXmMapper salPlanXmMapper;

    @Override
    public List<SalPlanXm> list(SalPlanXm salPlanXm, PageBean pageBean) {
        return salPlanXmMapper.list(salPlanXm);
    }

    @Override
    public int add(SalPlanXm salPlanXm) {
        return salPlanXmMapper.insertSelective(salPlanXm);
    }

    @Override
    public int del(SalPlanXm salPlanXm) {
        return salPlanXmMapper.deleteByPrimaryKey(salPlanXm.getPlaId());
    }

    @Override
    public SalPlanXm load(SalPlanXm salPlanXm) {
        return salPlanXmMapper.selectByPrimaryKey(salPlanXm.getPlaId());
    }

    @Override
    public int edit(SalPlanXm salPlanXm) {
        return salPlanXmMapper.updateByPrimaryKeySelective(salPlanXm);
    }
}
