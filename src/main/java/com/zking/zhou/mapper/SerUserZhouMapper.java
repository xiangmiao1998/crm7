package com.zking.zhou.mapper;

import com.zking.zhou.model.SerUserZhou;

import java.util.List;

public interface SerUserZhouMapper {
    int deleteByPrimaryKey(Integer usrId);

    int insert(SerUserZhou record);

    int insertSelective(SerUserZhou record);

    SerUserZhou selectByPrimaryKey(Integer usrId);

    int updateByPrimaryKeySelective(SerUserZhou record);

    int updateByPrimaryKey(SerUserZhou record);

    List<SerUserZhou> list(SerUserZhou suz);
}