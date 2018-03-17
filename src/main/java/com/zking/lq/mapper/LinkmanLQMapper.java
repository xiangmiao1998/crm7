package com.zking.lq.mapper;

import com.zking.lq.model.LinkmanLQ;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkmanLQMapper {
    int deleteByPrimaryKey(Long lkmId);

    int insert(LinkmanLQ record);

    int insertSelective(LinkmanLQ record);

    LinkmanLQ selectByPrimaryKey(Long lkmId);

    int updateByPrimaryKeySelective(LinkmanLQ record);

    int updateByPrimaryKey(LinkmanLQ record);

    List<LinkmanLQ> list(LinkmanLQ linkmanLQ);
}