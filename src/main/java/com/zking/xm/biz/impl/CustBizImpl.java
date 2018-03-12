package com.zking.xm.biz.impl;

import com.zking.xm.biz.ICustBiz;
import com.zking.xm.mapper.CustomerMapper;
import com.zking.xm.mapper.OrdersMapper;
import com.zking.xm.model.Customer;
import com.zking.xm.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustBizImpl implements ICustBiz {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public int selectCount() {
        return customerMapper.selectCount();
    }

    @Override
    public int add(Customer customer) {
        return customerMapper.insertSelective(customer);
    }

    @Override
    public int add(Orders orders) {
        return ordersMapper.insertSelective(orders);
    }
}
