package com.zking.xm.mapper;

import com.zking.xm.model.Storage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageMapper {
    int deleteByPrimaryKey(Long stkId);

    int insert(Storage record);

    int insertSelective(Storage record);

    Storage selectByPrimaryKey(Long stkId);

    List<Storage> list(Storage storage);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);
}