package com.zking.xm.biz.impl;

import com.zking.util.PageBean;
import com.zking.xm.biz.IDictBiz;
import com.zking.xm.mapper.DictXmMapper;
import com.zking.xm.model.DictXm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictBizImpl implements IDictBiz {

    @Autowired
    private DictXmMapper dictXmMapper;

    @Override
    public int add(DictXm dictXm) {
        return dictXmMapper.insertSelective(dictXm);
    }

    @Override
    public List<DictXm> list(DictXm dictXm, PageBean pageBean) {
        return dictXmMapper.list(dictXm);
    }

    @Override
    public int del(DictXm dictXm) {
        return dictXmMapper.deleteByPrimaryKey(dictXm.getDictId());
    }

    @Override
    public DictXm load(DictXm dictXm) {
        return dictXmMapper.selectByPrimaryKey(dictXm.getDictId());
    }

    @Override
    public int edit(DictXm dictXm) {
        return dictXmMapper.updateByPrimaryKeySelective(dictXm);
    }
}
