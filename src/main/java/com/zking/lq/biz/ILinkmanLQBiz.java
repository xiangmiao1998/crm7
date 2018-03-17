package com.zking.lq.biz;

import com.zking.lq.model.LinkmanLQ;
import com.zking.util.PageBean;

import java.util.List;

public interface ILinkmanLQBiz {

    //新增联系人
    int add(LinkmanLQ linkmanLQ);

    //显示当前用户的所有联系人
    List<LinkmanLQ> list(LinkmanLQ linkmanLQ, PageBean pageBean);

    //显示单个联系人的信息
    LinkmanLQ loadBylkmId(LinkmanLQ linkmanLQ);

    //根据联系人ID修改信息
    int edit(LinkmanLQ linkmanLQ);

    //删除联系人
    int del(LinkmanLQ linkmanLQ);
}
