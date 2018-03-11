package com.zking.xm.biz;

import com.zking.xm.model.UserXm;

import java.util.List;

public interface IUserBiz {
    List<UserXm> list(UserXm userXm);

    UserXm load(UserXm userXm);
}
