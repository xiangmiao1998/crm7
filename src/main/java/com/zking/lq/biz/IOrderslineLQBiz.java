package com.zking.lq.biz;

import com.zking.lq.model.OrderslineLQ;
import com.zking.util.PageBean;

import java.util.List;

public interface IOrderslineLQBiz {

    List<OrderslineLQ> list(OrderslineLQ orderslineLQ, PageBean pageBean);

}
