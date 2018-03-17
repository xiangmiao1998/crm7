package com.zking.zhou.biz.impl;

import com.zking.zhou.biz.ISerUserZhouBiz;
import com.zking.zhou.mapper.SerUserZhouMapper;
import com.zking.zhou.model.SerUserZhou;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ISerUserZhouBizImpl implements ISerUserZhouBiz {
    @Autowired
    private SerUserZhouMapper serUserZhouMapper ;

    @Override
    public List<SerUserZhou> list(SerUserZhou suz) {
        return serUserZhouMapper.list(suz);
    }


    @Override
    public SerUserZhou load(SerUserZhou suz) {
        return serUserZhouMapper.selectByPrimaryKey(suz.getUsrId());
    }




}
