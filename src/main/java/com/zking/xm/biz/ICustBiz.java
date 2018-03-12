package com.zking.xm.biz;

import com.zking.xm.model.Customer;
import com.zking.xm.model.Orders;

public interface ICustBiz {

    int selectCount();

    int add(Customer customer);

    int add(Orders orders);
}
