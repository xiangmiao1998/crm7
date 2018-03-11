package com.zking.xm.mapper;

import com.zking.xm.model.DictXm;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictXmMapper {
    int deleteByPrimaryKey(Long dictId);

    int insert(DictXm record);

    int insertSelective(DictXm record);

    DictXm selectByPrimaryKey(Long dictId);

    List<DictXm> list(DictXm dictXm);

    int updateByPrimaryKeySelective(DictXm record);

    int updateByPrimaryKey(DictXm record);
}