package com.zking.lq.controller;

import com.zking.lq.biz.IOrdersLQBiz;
import com.zking.lq.biz.IOrderslineLQBiz;
import com.zking.lq.biz.IProductLQBiz;
import com.zking.lq.model.CustomerLQ;
import com.zking.lq.model.OrdersLQ;
import com.zking.lq.model.OrderslineLQ;
import com.zking.lq.model.ProductLQ;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/orderslineLQ")
public class OrderslineLQController {

    @Autowired
    private IOrderslineLQBiz orderslineLQBiz;
    @Autowired
    private IOrdersLQBiz ordersLQBiz;
    @Autowired
    private IProductLQBiz productLQBiz;

    private OrderslineLQ orderslineLQ;
    private OrdersLQ ordersLQ;
    private ProductLQ productLQ;

    //标识非请求方法
    @ModelAttribute
    public void init(Model model){
        orderslineLQ = new OrderslineLQ();
        ordersLQ = new OrdersLQ();
        productLQ = new ProductLQ();
    }

    @RequestMapping("/look")
    public String look(HttpSession session,OrdersLQ ordersLQ){
        session.setAttribute("ordersId",ordersLQ.getOdrId());
        orderslineLQ.setOddOrderId(ordersLQ.getOdrId());
        //根据ordersId查找所有订单明细
        List<OrderslineLQ> list = orderslineLQBiz.list(orderslineLQ, null);
        Float money=0F;
       for(OrderslineLQ ordersline:list){
            money=money+(ordersline.getOddCount()*ordersline.getOddPrice());
        }
        OrdersLQ o = ordersLQBiz.loadByordersId(ordersLQ);
        o.setMoney(money);

        Date time=o.getOdrDate();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String t=sf.format(time);
        o.setTime(t);

        if("a".equals(o.getOdrStatus())){
            o.setStatus("已回款");
        }else{
            o.setStatus("未回款");
        }

        session.setAttribute("o",o);
        return "cust/cust/orders_detail";
    }



    @RequestMapping("/list")
    @ResponseBody
    public ResponseData list(HttpSession session, HttpServletRequest request){
        //订单编号
        Long ordersId = (Long)session.getAttribute("ordersId");
        orderslineLQ.setOddOrderId(ordersId);

        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        //根据ordersId查找所有订单明细
        List<OrderslineLQ> list = orderslineLQBiz.list(orderslineLQ, pageBean);
        for(OrderslineLQ ordersline:list){
            //查找商品id查找商品
            productLQ.setProdId(ordersline.getOddProdId());
            ProductLQ pro = productLQBiz.loadByprodId(productLQ);
            ordersline.setProdName(pro.getProdName()+"-"+pro.getProdType());
            ordersline.setMoney(ordersline.getOddCount()*ordersline.getOddPrice());
        }
        ResponseData date = new ResponseData();
        date.setTotal(pageBean.getTotalRecord());
        date.setRows(list);
        return date;
    }


}
