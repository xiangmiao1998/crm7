package com.zking.lq.biz.impl;

import com.zking.lq.biz.IProductLQBiz;
import com.zking.lq.mapper.ProductLQMapper;
import com.zking.lq.model.ProductLQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IProductLQBizImpl implements IProductLQBiz {

    @Autowired
    private ProductLQMapper productLQMapper;

    @Override
    public ProductLQ loadByprodId(ProductLQ productLQ) {
        return productLQMapper.selectByPrimaryKey(productLQ.getProdId());
    }
}
