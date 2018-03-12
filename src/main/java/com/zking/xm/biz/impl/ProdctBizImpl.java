package com.zking.xm.biz.impl;

import com.zking.util.PageBean;
import com.zking.xm.biz.IProdctBiz;
import com.zking.xm.mapper.ProductMapper;
import com.zking.xm.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdctBizImpl implements IProdctBiz {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> list(Product product, PageBean pageBean) {
        return productMapper.list(product);
    }
}
