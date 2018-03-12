package com.zking.xm.controller;

import com.zking.xm.biz.ICustBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cust")
public class CustController {

    @Autowired
    private ICustBiz custBiz;


}
