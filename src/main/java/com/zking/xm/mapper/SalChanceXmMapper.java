package com.zking.xm.mapper;

import com.zking.xm.model.SalChanceXm;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalChanceXmMapper {
    int deleteByPrimaryKey(Long chcId);

    int insert(SalChanceXm record);

    int insertSelective(SalChanceXm record);

    SalChanceXm selectByPrimaryKey(Long chcId);

    List<SalChanceXm> list(SalChanceXm salChanceXm);

    int updateByPrimaryKeySelective(SalChanceXm record);

    int updateByPrimaryKey(SalChanceXm record);
}