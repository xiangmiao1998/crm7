package com.zking.xm.biz.impl;

import com.zking.xm.biz.IUserBiz;
import com.zking.xm.mapper.UserXmMapper;
import com.zking.xm.model.UserXm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBizImpl implements IUserBiz {

    @Autowired
    private UserXmMapper userXmMapper;

    @Override
    public List<UserXm> list(UserXm userXm) {
        return userXmMapper.list(userXm);
    }

    @Override
    public UserXm load(UserXm userXm) {
        return userXmMapper.selectByPrimaryKey(userXm.getUsrId());
    }
}
