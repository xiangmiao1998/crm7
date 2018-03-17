package com.zking.lq.biz;

import com.zking.lq.model.ActivityLQ;
import com.zking.util.PageBean;
import org.omg.CORBA.ACTIVITY_COMPLETED;

import java.util.List;

public interface IActivityLQBiz {

    //查看当前用户的交往记录
    List<ActivityLQ> list(ActivityLQ activityLQ, PageBean pageBean);

    //增加一条交往记录
    int add(ActivityLQ activityLQ);

    //查看一条交往记录
    ActivityLQ loadByatvId(ActivityLQ activityLQ);

    //修改交往记录
    int edit(ActivityLQ activityLQ);

    //删除交往记录
    int del(ActivityLQ activityLQ);



}
