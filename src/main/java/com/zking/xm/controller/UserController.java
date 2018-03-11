package com.zking.xm.controller;

import com.zking.xm.biz.IUserBiz;
import com.zking.xm.model.UserXm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserBiz userBiz;

    @RequestMapping("/list")
    @ResponseBody
    public List<UserXm> list(UserXm userXm) {
        List<UserXm> list = userBiz.list(userXm);
        return list;
    }
}
