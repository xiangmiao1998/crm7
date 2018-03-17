package com.zking.lq.mapper;

import com.zking.lq.model.OrderslineLQ;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderslineLQMapper {
    int deleteByPrimaryKey(Long oddId);

    int insert(OrderslineLQ record);

    int insertSelective(OrderslineLQ record);

    OrderslineLQ selectByPrimaryKey(Long oddId);

    int updateByPrimaryKeySelective(OrderslineLQ record);

    int updateByPrimaryKey(OrderslineLQ record);

    List<OrderslineLQ> list(OrderslineLQ orderslineLQ);
}