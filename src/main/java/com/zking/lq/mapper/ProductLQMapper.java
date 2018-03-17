package com.zking.lq.mapper;

import com.zking.lq.model.ProductLQ;

public interface ProductLQMapper {
    int deleteByPrimaryKey(Long prodId);

    int insert(ProductLQ record);

    int insertSelective(ProductLQ record);

    ProductLQ selectByPrimaryKey(Long prodId);

    int updateByPrimaryKeySelective(ProductLQ record);

    int updateByPrimaryKey(ProductLQ record);
}