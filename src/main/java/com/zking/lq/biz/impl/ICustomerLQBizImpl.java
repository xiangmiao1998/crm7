package com.zking.lq.biz.impl;

import com.zking.lq.biz.ICustomerLQBiz;
import com.zking.lq.mapper.CustomerLQMapper;
import com.zking.lq.model.CustomerLQ;
import com.zking.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICustomerLQBizImpl implements ICustomerLQBiz {

    @Autowired
    private CustomerLQMapper customerLQMapper;

    @Override
    public void add(CustomerLQ customerLQ) {
        customerLQMapper.insert(customerLQ);
    }

    @Override
    public List<CustomerLQ> list(CustomerLQ customerLQ, PageBean pageBean) {
        return customerLQMapper.list(customerLQ);
    }

    @Override
    public CustomerLQ loadBycustNo(CustomerLQ customerLQ) {
        return customerLQMapper.selectByPrimaryKey(customerLQ.getCustNo());
    }

    @Override
    public int edit(CustomerLQ customerLQ) {
        return customerLQMapper.updateByPrimaryKey(customerLQ);
    }

    @Override
    public int del(CustomerLQ customerLQ) {
        return customerLQMapper.deleteByPrimaryKey(customerLQ.getCustNo());
    }
}
