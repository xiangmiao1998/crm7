package com.zking.lq.controller;

import com.zking.lq.biz.IActivityLQBiz;
import com.zking.lq.biz.ICustomerLQBiz;
import com.zking.lq.model.ActivityLQ;
import com.zking.lq.model.CustomerLQ;
import com.zking.lq.model.LinkmanLQ;
import com.zking.util.PageBean;
import com.zking.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/activityLQ")
public class ActivityLQController {

    @Autowired
    private IActivityLQBiz activityLQBiz;
    @Autowired
    private ICustomerLQBiz customerLQBiz;

    private ActivityLQ activityLQ;
    private CustomerLQ customerLQ;

    @ModelAttribute
    public void init(){
        activityLQ = new ActivityLQ();
        customerLQ = new CustomerLQ();
    }

    @RequestMapping("/look")
    public String look(HttpSession session, CustomerLQ customerLQ){
        CustomerLQ customerLQ1 = customerLQBiz.loadBycustNo(customerLQ);
        session.setAttribute("cust2",customerLQ1);
        return "cust/cust/activities";
    }

    //根据custNo查询相应的交往记录
    @RequestMapping("/list")
    @ResponseBody
    public ResponseData list(HttpSession session, HttpServletRequest request){
        CustomerLQ cust2 = (CustomerLQ)session.getAttribute("cust2");
        activityLQ.setAtvCustNo(cust2.getCustNo());
        activityLQ.setAtvCustName(cust2.getCustName());
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<ActivityLQ> activityLQList = activityLQBiz.list(activityLQ, pageBean);
        ResponseData date = new ResponseData();
        date.setTotal(pageBean.getTotalRecord());
        date.setRows(activityLQList);
        return date;
    }

    @RequestMapping("/add")
    @ResponseBody
    public int add(ActivityLQ activityLQ,HttpSession session){
        String date=activityLQ.getDate();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date atvDate = sf.parse(date);
            activityLQ.setAtvDate(atvDate);
        }catch (Exception e){
            e.printStackTrace();
        }
        CustomerLQ cust2 = (CustomerLQ)session.getAttribute("cust2");
        activityLQ.setAtvCustNo(cust2.getCustNo());
        activityLQ.setAtvCustName(cust2.getCustName());
        int row = activityLQBiz.add(activityLQ);
        return row;
    }

    @RequestMapping("/loadBylatvId")
    @ResponseBody
    public ActivityLQ loadByatvId(ActivityLQ activityLQ){
        ActivityLQ activityLQ1 = activityLQBiz.loadByatvId(activityLQ);
        Date atvDate=activityLQ1.getAtvDate();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sf.format(atvDate);
        activityLQ1.setDate(date);
        System.out.println("时间："+activityLQ1.getDate());
        return activityLQ1;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public int edit(ActivityLQ activityLQ,HttpSession session){
        String date=activityLQ.getDate();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date atvDate = sf.parse(date);
            activityLQ.setAtvDate(atvDate);
        }catch (Exception e){
            e.printStackTrace();
        }
        CustomerLQ cust2 = (CustomerLQ)session.getAttribute("cust2");
        activityLQ.setAtvCustNo(cust2.getCustNo());
        activityLQ.setAtvCustName(cust2.getCustName());
        int i = activityLQBiz.edit(activityLQ);
        return i;
    }

    @RequestMapping("/del")
    @ResponseBody
    public int del(ActivityLQ activityLQ){
        int row = activityLQBiz.del(activityLQ);
        return row;
    }

}
