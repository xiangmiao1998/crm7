package com.zking.xm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
