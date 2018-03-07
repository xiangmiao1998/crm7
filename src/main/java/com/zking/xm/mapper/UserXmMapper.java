package com.zking.xm.mapper;

import com.zking.xm.model.UserXm;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UserXmMapper {
    int deleteByPrimaryKey(Integer usrId);

    int insert(UserXm record);

    int insertSelective(UserXm record);

    UserXm selectByPrimaryKey(Integer usrId);

    int updateByPrimaryKeySelective(UserXm record);

    int updateByPrimaryKey(UserXm record);
}