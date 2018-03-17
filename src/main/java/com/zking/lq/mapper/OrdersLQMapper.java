package com.zking.lq.mapper;

import com.zking.lq.model.OrdersLQ;

import java.util.List;

public interface OrdersLQMapper {
    int deleteByPrimaryKey(Long odrId);

    int insert(OrdersLQ record);

    int insertSelective(OrdersLQ record);

    OrdersLQ selectByPrimaryKey(Long odrId);

    int updateByPrimaryKeySelective(OrdersLQ record);

    int updateByPrimaryKey(OrdersLQ record);

    List<OrdersLQ> list(OrdersLQ ordersLQ);
}