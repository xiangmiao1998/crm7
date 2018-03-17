package com.zking.lq.biz;

import com.zking.lq.model.LostLQ;
import com.zking.util.PageBean;

import java.util.List;
import java.util.Queue;

public interface ILostLQBiz {

    //增加客户流失
    void add(LostLQ lostLQ);

    //显示所有的客户流失
    List<LostLQ> list(LostLQ lostLQ, PageBean pageBean);

    //查看单个
    LostLQ loadBylstId(LostLQ lostLQ);

    //修改
    int edit(LostLQ lostLQ);

}
