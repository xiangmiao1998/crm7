package com.zking.lq.biz;

import com.zking.lq.model.CustomerLQ;
import com.zking.util.PageBean;

import java.util.List;

public interface ICustomerLQBiz {
    //增加客户
    void add(CustomerLQ customerLQ);

    //显示所有客户
    List<CustomerLQ> list(CustomerLQ customerLQ, PageBean pageBean);

    //显示单个
    CustomerLQ loadBycustNo(CustomerLQ customerLQ);

    //修改信息
    int edit(CustomerLQ customerLQ);

    //删除客户
    int del(CustomerLQ customerLQ);



}
