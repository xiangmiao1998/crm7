package com.zking.lq.biz.impl;

import com.zking.lq.biz.IActivityLQBiz;
import com.zking.lq.mapper.ActivityLQMapper;
import com.zking.lq.model.ActivityLQ;
import com.zking.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.activity.ActivityCompletedException;
import java.util.List;

@Service
public class IActivityLQBizImpl implements IActivityLQBiz {

    @Autowired
    private ActivityLQMapper activityLQMapper;


    @Override
    public List<ActivityLQ> list(ActivityLQ activityLQ, PageBean pageBean) {
        return activityLQMapper.list(activityLQ);
    }

    @Override
    public int add(ActivityLQ activityLQ) {
        return activityLQMapper.insert(activityLQ);
    }

    @Override
    public ActivityLQ loadByatvId(ActivityLQ activityLQ) {
        return activityLQMapper.selectByPrimaryKey(activityLQ.getAtvId());
    }

    @Override
    public int edit(ActivityLQ activityLQ) {
        return activityLQMapper.updateByPrimaryKey(activityLQ);
    }

    @Override
    public int del(ActivityLQ activityLQ) {
        return activityLQMapper.deleteByPrimaryKey(activityLQ.getAtvId());
    }
}
