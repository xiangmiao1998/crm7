package com.zking.xm.mapper;

import com.zking.xm.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {
    int deleteByPrimaryKey(String custNo);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(String custNo);

    int selectCount();

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    List<Customer> listCount(Customer customer);
}