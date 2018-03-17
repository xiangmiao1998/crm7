package com.zking.lq.controller;

import com.zking.lq.biz.ICustomerLQBiz;
import com.zking.lq.biz.ILinkmanLQBiz;
import com.zking.lq.model.CustomerLQ;
import com.zking.lq.model.LinkmanLQ;
import com.zking.util.PageBean;
import com.zking.util.ResponseData;
import com.zking.xm.model.DictXm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/linkmanLQ")
public class LinkmanLQController {
    @Autowired
    private ILinkmanLQBiz linkmanLQBiz;

    @Autowired
    private ICustomerLQBiz customerLQBiz;

    private LinkmanLQ linkmanLQ;
    private CustomerLQ customerLQ;

    //标识非请求方法
    @ModelAttribute
    public void init(Model model){
        linkmanLQ = new LinkmanLQ();
        customerLQ = new CustomerLQ();
    }

    @RequestMapping("/look")
    public String look(HttpSession session,CustomerLQ customerLQ){
        CustomerLQ customerLQ1 = customerLQBiz.loadBycustNo(customerLQ);
        session.setAttribute("cust",customerLQ1);
        return "cust/cust/linkman";
    }

    //根据custNo查询相应的联系人
    @RequestMapping("/list")
    @ResponseBody
    public ResponseData list(HttpSession session,HttpServletRequest request){
        CustomerLQ cust = (CustomerLQ)session.getAttribute("cust");
        linkmanLQ.setLkmCustNo(cust.getCustNo());
        linkmanLQ.setLkmCustName(cust.getCustName());
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<LinkmanLQ> linkmanLQList = linkmanLQBiz.list(linkmanLQ, pageBean);
        ResponseData date = new ResponseData();
        date.setTotal(pageBean.getTotalRecord());
        date.setRows(linkmanLQList);
        return date;
    }


    @RequestMapping("/add")
    @ResponseBody
    public int add(Model model, LinkmanLQ linkmanLQ,HttpSession session) {
        CustomerLQ cust = (CustomerLQ)session.getAttribute("cust");
        linkmanLQ.setLkmCustNo(cust.getCustNo());
        linkmanLQ.setLkmCustName(cust.getCustName());
        int row=linkmanLQBiz.add(linkmanLQ);
        return row;
    }

    @RequestMapping("/loadBylkmId")
    @ResponseBody
    public LinkmanLQ loadBylkmId(LinkmanLQ linkmanLQ){
        LinkmanLQ lq = linkmanLQBiz.loadBylkmId(linkmanLQ);
        return lq;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public int edit(LinkmanLQ linkmanLQ,HttpSession session){
        CustomerLQ cust = (CustomerLQ)session.getAttribute("cust");
        linkmanLQ.setLkmCustNo(cust.getCustNo());
        linkmanLQ.setLkmCustName(cust.getCustName());
        int i = linkmanLQBiz.edit(linkmanLQ);
        return i;
    }

    @RequestMapping("/del")
    @ResponseBody
    public int del(LinkmanLQ linkmanLQ){
        int row = linkmanLQBiz.del(linkmanLQ);
        return row;
    }
}
