package com.zking.xm.biz.impl;

import com.zking.util.PageBean;
import com.zking.xm.biz.IStorageBiz;
import com.zking.xm.mapper.StorageMapper;
import com.zking.xm.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageBizImpl implements IStorageBiz {

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public List<Storage> list(Storage storage, PageBean pageBean) {
        return storageMapper.list(storage);
    }
}
