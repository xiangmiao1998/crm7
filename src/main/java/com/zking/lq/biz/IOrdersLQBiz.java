package com.zking.lq.biz;

import com.zking.lq.model.OrdersLQ;
import com.zking.util.PageBean;

import java.util.List;

public interface IOrdersLQBiz {
    List<OrdersLQ> list(OrdersLQ ordersLQ, PageBean pageBean);

    OrdersLQ loadByordersId(OrdersLQ ordersLQ);
}
