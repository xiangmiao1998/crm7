package com.zking.xm.mapper;

import com.zking.xm.model.Linkman;

public interface LinkmanMapper {
    int deleteByPrimaryKey(Long lkmId);

    int insert(Linkman record);

    int insertSelective(Linkman record);

    Linkman selectByPrimaryKey(Long lkmId);

    int updateByPrimaryKeySelective(Linkman record);

    int updateByPrimaryKey(Linkman record);
}