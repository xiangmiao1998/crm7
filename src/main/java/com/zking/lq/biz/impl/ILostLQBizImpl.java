package com.zking.lq.biz.impl;

import com.zking.lq.biz.ILostLQBiz;
import com.zking.lq.mapper.LostLQMapper;
import com.zking.lq.model.LostLQ;
import com.zking.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ILostLQBizImpl implements ILostLQBiz {

    @Autowired
    private LostLQMapper lostLQMapper;

    @Override
    public void add(LostLQ lostLQ) {
    }

    @Override
    public List<LostLQ> list(LostLQ lostLQ, PageBean pageBean) {
        return lostLQMapper.list(lostLQ);
    }

    @Override
    public LostLQ loadBylstId(LostLQ lostLQ) {
        return lostLQMapper.selectByPrimaryKey(lostLQ.getLstId());
    }

    @Override
    public int edit(LostLQ lostLQ) {
        return lostLQMapper.updateByPrimaryKey(lostLQ);
    }
}
