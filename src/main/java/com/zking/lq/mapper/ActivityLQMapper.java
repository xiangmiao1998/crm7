package com.zking.lq.mapper;

import com.zking.lq.model.ActivityLQ;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ActivityLQMapper {
    int deleteByPrimaryKey(Long atvId);

    int insert(ActivityLQ record);

    int insertSelective(ActivityLQ record);

    ActivityLQ selectByPrimaryKey(Long atvId);

    int updateByPrimaryKeySelective(ActivityLQ record);

    int updateByPrimaryKey(ActivityLQ record);

    List<ActivityLQ> list(ActivityLQ activityLQ);
}