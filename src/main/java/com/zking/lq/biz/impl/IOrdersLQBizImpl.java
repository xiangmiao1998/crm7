package com.zking.lq.biz.impl;

import com.zking.lq.biz.IOrdersLQBiz;
import com.zking.lq.mapper.OrdersLQMapper;
import com.zking.lq.model.OrdersLQ;
import com.zking.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IOrdersLQBizImpl implements IOrdersLQBiz {
    @Autowired
    private OrdersLQMapper ordersLQMapper;

    @Override
    public List<OrdersLQ> list(OrdersLQ ordersLQ, PageBean pageBean) {
        return ordersLQMapper.list(ordersLQ);
    }

    @Override
    public OrdersLQ loadByordersId(OrdersLQ ordersLQ) {
        return ordersLQMapper.selectByPrimaryKey(ordersLQ.getOdrId());
    }
}
