package com.zking.xm.mapper;

import com.zking.xm.model.SalPlanXm;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface SalPlanXmMapper {
    int deleteByPrimaryKey(Long plaId);

    int insert(SalPlanXm record);

    int insertSelective(SalPlanXm record);

    SalPlanXm selectByPrimaryKey(Long plaId);

    List<SalPlanXm> list(SalPlanXm salPlanXm);

    int updateByPrimaryKeySelective(SalPlanXm record);

    int updateByPrimaryKey(SalPlanXm record);
}