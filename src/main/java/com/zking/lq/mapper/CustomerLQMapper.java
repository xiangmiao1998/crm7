package com.zking.lq.mapper;

import com.zking.lq.model.CustomerLQ;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface CustomerLQMapper {
    int deleteByPrimaryKey(String custNo);

    int insert(CustomerLQ record);

    int insertSelective(CustomerLQ record);

    CustomerLQ selectByPrimaryKey(String custNo);

    int updateByPrimaryKeySelective(CustomerLQ record);

    int updateByPrimaryKey(CustomerLQ record);

    List<CustomerLQ> list(CustomerLQ customerLQ);
}