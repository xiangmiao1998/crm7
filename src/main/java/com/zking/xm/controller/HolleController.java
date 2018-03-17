package com.zking.xm.controller;

import com.zking.xm.model.UserXm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/holle")
public class HolleController {

    @RequestMapping("/toa")
    public String toA(){
        return "aa";
    }

    @RequestMapping("/tox")
    public String toX(){
        return "basd/dict_add";
    }

    @RequestMapping("/toSer")
    public String toSer() {
        return "rept/ser";
    }


    @RequestMapping("/getUser")
    @ResponseBody
    public UserXm getUser(HttpSession session) {
        UserXm user = (UserXm) session.getAttribute("user");
        return user;
    }
}
