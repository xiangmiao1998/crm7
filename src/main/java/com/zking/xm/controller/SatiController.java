package com.zking.xm.controller;

import com.zking.xm.biz.ISatiBiz;
import com.zking.xm.model.Satisfy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sati")
public class SatiController {

    @Autowired
    private ISatiBiz satiBiz;


    @RequestMapping("/listGroup")
    @ResponseBody
    public List<Integer> listGroup(Satisfy satisfy) {
        return satiBiz.listCount(satisfy);
    }

}
