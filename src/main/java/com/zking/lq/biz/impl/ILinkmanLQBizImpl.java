package com.zking.lq.biz.impl;

import com.zking.lq.biz.ILinkmanLQBiz;
import com.zking.lq.mapper.LinkmanLQMapper;
import com.zking.lq.model.LinkmanLQ;
import com.zking.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ILinkmanLQBizImpl implements ILinkmanLQBiz {

    @Autowired
    private LinkmanLQMapper linkmanLQMapper;

    @Override
    public int add(LinkmanLQ linkmanLQ) {
        return linkmanLQMapper.insert(linkmanLQ);
    }

    @Override
    public List<LinkmanLQ> list(LinkmanLQ linkmanLQ, PageBean pageBean) {
        return linkmanLQMapper.list(linkmanLQ);
    }

    @Override
    public LinkmanLQ loadBylkmId(LinkmanLQ linkmanLQ) {
        return linkmanLQMapper.selectByPrimaryKey(linkmanLQ.getLkmId());
    }

    @Override
    public int edit(LinkmanLQ linkmanLQ) {
        return linkmanLQMapper.updateByPrimaryKey(linkmanLQ);
    }

    @Override
    public int del(LinkmanLQ linkmanLQ) {
        return linkmanLQMapper.deleteByPrimaryKey(linkmanLQ.getLkmId());
    }
}
