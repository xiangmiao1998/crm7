package com.zking.zhou.mapper;

import com.zking.util.PageBean;
import com.zking.zhou.model.SerSatisftZhou;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerSatisftZhouMapper {
    int deleteByPrimaryKey(Integer svrId);

    int insert(SerSatisftZhou record);

    int insertSelective(SerSatisftZhou record);

    SerSatisftZhou selectByPrimaryKey(Integer svrId);

    int updateByPrimaryKeySelective(SerSatisftZhou record);

    int updateByPrimaryKey(SerSatisftZhou record);

    List<SerSatisftZhou> list(SerSatisftZhou ssz);
}