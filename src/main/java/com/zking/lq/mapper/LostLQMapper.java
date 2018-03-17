package com.zking.lq.mapper;

import com.zking.lq.model.LostLQ;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LostLQMapper {
    int deleteByPrimaryKey(Long lstId);

    int insert(LostLQ record);

    int insertSelective(LostLQ record);

    LostLQ selectByPrimaryKey(Long lstId);

    int updateByPrimaryKeySelective(LostLQ record);

    int updateByPrimaryKey(LostLQ record);

    List<LostLQ> list(LostLQ lostLQ);
}