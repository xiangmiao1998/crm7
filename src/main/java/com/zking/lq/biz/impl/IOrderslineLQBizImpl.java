package com.zking.lq.biz.impl;

import com.zking.lq.biz.IOrderslineLQBiz;
import com.zking.lq.mapper.OrderslineLQMapper;
import com.zking.lq.model.OrderslineLQ;
import com.zking.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IOrderslineLQBizImpl implements IOrderslineLQBiz {
    @Autowired
    private OrderslineLQMapper orderslineLQMapper;

    @Override
    public List<OrderslineLQ> list(OrderslineLQ orderslineLQ, PageBean pageBean) {
        return orderslineLQMapper.list(orderslineLQ);
    }
}
