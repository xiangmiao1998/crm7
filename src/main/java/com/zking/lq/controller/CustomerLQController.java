package com.zking.lq.controller;

import com.zking.lq.biz.ICustomerLQBiz;
import com.zking.lq.model.CustomerLQ;
import com.zking.util.PageBean;
import com.zking.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/customerLQ")
public class CustomerLQController {

    @Autowired
    private ICustomerLQBiz customerLQBiz;

    private CustomerLQ customerLQ;

    //标识非请求方法
    @ModelAttribute
    public void init(Model model){
        customerLQ = new CustomerLQ();
    }

    @RequestMapping("/look")
    public String look(){
        return  "cust/cust/list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResponseData list(HttpServletRequest request,CustomerLQ customerLQ){
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<CustomerLQ> customerLQList = customerLQBiz.list(customerLQ, pageBean);
        for(CustomerLQ c:customerLQList){
            if("1".equals(c.getCustStatus())||"1"==c.getCustStatus()){
                c.setStatus("是");
            }else{
                c.setStatus("否");
            }
        }
        ResponseData data = new ResponseData();
        data.setTotal(pageBean.getTotalRecord());
        data.setRows(customerLQList);
        return data;
    }

    @RequestMapping("/loadBycustNo")
    @ResponseBody
    public CustomerLQ loadBycustNo(HttpSession session,CustomerLQ customerLQ){
        CustomerLQ cust = customerLQBiz.loadBycustNo(customerLQ);
        return cust;
    }

    @RequestMapping("/del")
    @ResponseBody
    public int del(CustomerLQ customerLQ){
        CustomerLQ customerLQ1 = customerLQBiz.loadBycustNo(customerLQ);
        customerLQ1.setCustStatus("4");
        int row = customerLQBiz.edit(customerLQ1);
        return row;
    }

    @RequestMapping("/test")
    public String test(CustomerLQ customerLQ, HttpSession session){
        CustomerLQ cust = customerLQBiz.loadBycustNo(customerLQ);
        session.setAttribute("c", cust);
        return "cust/cust/edit";
    }
    
    @RequestMapping("/edit")
    @ResponseBody
    public int edit(CustomerLQ customerLQ){
        customerLQ.setCustStatus("1");
        int row = customerLQBiz.edit(customerLQ);
        return row;
    }


}
