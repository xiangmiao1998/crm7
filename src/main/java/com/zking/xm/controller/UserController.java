package com.zking.xm.controller;

import com.zking.xm.biz.IUserBiz;
import com.zking.xm.model.UserXm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/userXm")
public class UserController {

    @Autowired
    private IUserBiz userBiz;

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<UserXm> list(UserXm userXm) {
        List<UserXm> list = userBiz.list(userXm);
        return list;
    }

    @RequestMapping("/load")
    public String load(UserXm userXm, HttpSession session) {
        String url = "aa";
        UserXm user = userBiz.load(userXm);
        if (null == user) {
            System.out.println("账号错误！");
            url = "login";
        } else {
            if (!userXm.getUsrPassword().equals(user.getUsrPassword())) {
                System.out.println("密码错误！");
                url = "login";
            }
            session.setAttribute("user", user);
        }
        return url;
    }
}
