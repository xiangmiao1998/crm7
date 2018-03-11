package com.zking.xm.controller;

import com.zking.util.PageBean;
import com.zking.util.ResponseData;
import com.zking.xm.biz.ISalPlanBiz;
import com.zking.xm.model.SalPlanXm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/salPlan")
public class SalPlanController {

    @Autowired
    private ISalPlanBiz salPlanBiz;

    @RequestMapping("/list")
    @ResponseBody
    public ResponseData list(HttpServletRequest request, SalPlanXm salPlanXm) {
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<SalPlanXm> planXmList = salPlanBiz.list(salPlanXm, pageBean);
        ResponseData data = new ResponseData();
        data.setTotal(pageBean.getTotalRecord());
        data.setRows(planXmList);
        return data;
    }

    @RequestMapping("/load")
    @ResponseBody
    public SalPlanXm load(SalPlanXm salPlanXm) {
        return salPlanBiz.load(salPlanXm);
    }

    @RequestMapping("/add")
    @ResponseBody
    public int add(SalPlanXm salPlanXm, HttpServletRequest request) {
        String strDate = request.getParameter("Date");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date date = sdf.parse(strDate);
            salPlanXm.setPlaDate(new Date(date.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int a = salPlanBiz.add(salPlanXm);
        return a;
    }


    @RequestMapping("/del")
    @ResponseBody
    public int del(SalPlanXm salPlanXm) {
        return salPlanBiz.del(salPlanXm);
    }

    @RequestMapping("/edit")
    @ResponseBody
    public int edit(SalPlanXm salPlanXm) {
        return salPlanBiz.edit(salPlanXm);
    }
}
