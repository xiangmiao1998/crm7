package com.zking.lq.controller;

import com.zking.lq.biz.ICustomerLQBiz;
import com.zking.lq.biz.IOrdersLQBiz;
import com.zking.lq.model.CustomerLQ;
import com.zking.lq.model.OrdersLQ;
import com.zking.lq.model.OrderslineLQ;
import com.zking.util.PageBean;
import com.zking.util.ResponseData;
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
@RequestMapping("/ordersLQ")
public class OrdersLQController {

    @Autowired
    private IOrdersLQBiz ordersLQBiz;

    @Autowired
    private ICustomerLQBiz customerLQBiz;

    private OrdersLQ ordersLQ;
    private CustomerLQ customerLQ;
    //标识非请求方法
    @ModelAttribute
    public void init(Model model){
        ordersLQ = new OrdersLQ();
        customerLQ = new CustomerLQ();
    }

    @RequestMapping("/look")
    public String look(HttpSession session,CustomerLQ customerLQ){
        CustomerLQ customerLQ1 = customerLQBiz.loadBycustNo(customerLQ);
        session.setAttribute("cust3",customerLQ1);
        return "cust/cust/orders";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResponseData list(HttpSession session, HttpServletRequest request){
        System.out.println("这是list方法");
        CustomerLQ cust3 = (CustomerLQ)session.getAttribute("cust3");
        ordersLQ.setOdrCustomer(cust3.getCustNo());
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<OrdersLQ> ordersLQList = ordersLQBiz.list(ordersLQ, pageBean);
        for(OrdersLQ orders:ordersLQList){
            if("a".equals(orders.getOdrStatus())){
                orders.setStatus("已回款");
            }else{
                orders.setStatus("未回款");
            }
        }
        ResponseData date = new ResponseData();
        date.setTotal(pageBean.getTotalRecord());
        date.setRows(ordersLQList);
        return date;
    }


}
