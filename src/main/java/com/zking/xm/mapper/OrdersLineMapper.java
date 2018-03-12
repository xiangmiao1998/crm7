package com.zking.xm.mapper;

import com.zking.xm.model.OrdersLine;

public interface OrdersLineMapper {
    int deleteByPrimaryKey(Long oddId);

    int insert(OrdersLine record);

    int insertSelective(OrdersLine record);

    OrdersLine selectByPrimaryKey(Long oddId);

    int updateByPrimaryKeySelective(OrdersLine record);

    int updateByPrimaryKey(OrdersLine record);
}