package com.zking.xm.mapper;

import com.zking.xm.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Long prodId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long prodId);

    List<Product> list(Product product);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}