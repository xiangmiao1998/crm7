package com.zking.zhou.biz.impl;

import com.zking.util.PageBean;
import com.zking.zhou.biz.ISerSatisfzZhouBiz;
import com.zking.zhou.mapper.SerSatisftZhouMapper;
import com.zking.zhou.mapper.SerUserZhouMapper;
import com.zking.zhou.model.SerSatisftZhou;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ISerSatisfzZhouBizImpl implements ISerSatisfzZhouBiz {
    @Autowired
    private SerSatisftZhouMapper serSatisftZhouMapper;
    @Override
    public void add(SerSatisftZhou ssz) {
        serSatisftZhouMapper.insert(ssz);
    }

    @Override
    public List<SerSatisftZhou> list(PageBean pageBean, SerSatisftZhou ssz) {
        return serSatisftZhouMapper.list(ssz);
    }

    @Override
    public int edit(SerSatisftZhou ssz){
        return serSatisftZhouMapper.updateByPrimaryKeySelective(ssz);
    }

    @Override
    public void del(SerSatisftZhou ssz){
      serSatisftZhouMapper.deleteByPrimaryKey(ssz.getSvrId());
    }

    @Override
    public SerSatisftZhou load(SerSatisftZhou ssz){
        return serSatisftZhouMapper.selectByPrimaryKey(ssz.getSvrId());
    }
}
