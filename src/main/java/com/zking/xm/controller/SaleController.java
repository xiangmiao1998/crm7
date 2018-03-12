package com.zking.xm.controller;

import com.zking.util.PageBean;
import com.zking.util.ResponseData;
import com.zking.xm.biz.ICustBiz;
import com.zking.xm.biz.ISaleBiz;
import com.zking.xm.biz.IUserBiz;
import com.zking.xm.model.Customer;
import com.zking.xm.model.Orders;
import com.zking.xm.model.SalChanceXm;
import com.zking.xm.model.UserXm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private ISaleBiz saleBiz;

    @Autowired
    private IUserBiz userBiz;

    @Autowired
    private ICustBiz custBiz;


    @RequestMapping("/tolist")
    public String toList() {
        return "sale/list";
    }

    @RequestMapping("/devlist")
    public String devList() {
        return "sale/dev";
    }

    @RequestMapping("/listSale")
    @ResponseBody
    public ResponseData listSale(HttpServletRequest request, SalChanceXm salChanceXm, HttpSession session) {
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        String panduan = request.getParameter("panduan");
        if (panduan.equals("plan")) {
            UserXm user = (UserXm) session.getAttribute("user");
            long ids = user.getUsrId();
            salChanceXm.setChcDueId(ids);
        }
        List<SalChanceXm> chanceXmList = saleBiz.list(salChanceXm, pageBean);
        ResponseData data = new ResponseData();
        data.setTotal(pageBean.getTotalRecord());
        data.setRows(chanceXmList);
        return data;
    }


    @RequestMapping("/addSale")
    @ResponseBody
    public int add(SalChanceXm salChanceXm, HttpSession session) {
        UserXm user = (UserXm) session.getAttribute("user");
        long ids = user.getUsrId();
        salChanceXm.setChcCreateId(ids);
        salChanceXm.setChcCreateBy(user.getUsrName());
        salChanceXm.setChcCreateDate(new Date(new java.util.Date().getTime()));
        salChanceXm.setChcStatus("未指派");
        return saleBiz.add(salChanceXm);
    }

    @RequestMapping("/delSale")
    @ResponseBody
    public int del(SalChanceXm salChanceXm) {
        return saleBiz.del(salChanceXm);
    }


    @RequestMapping("/doZhiPai")
    @ResponseBody
    public int doZhiPai(SalChanceXm salChanceXm) {
        UserXm user = new UserXm();
        user.setUsrId(Integer.parseInt(salChanceXm.getChcDueId().toString()));
        UserXm u = userBiz.load(user);
        salChanceXm.setChcDueTo(u.getUsrName());
        salChanceXm.setChcDueDate(new Date(new java.util.Date().getTime()));
        salChanceXm.setChcStatus("开发中");
        return saleBiz.edit(salChanceXm);
    }


    @RequestMapping("/loadSale")
    @ResponseBody
    public SalChanceXm load(SalChanceXm salChanceXm, Model model) {
        SalChanceXm chanceXm = saleBiz.load(salChanceXm);
        return chanceXm;
    }


    @RequestMapping("/editSale")
    @ResponseBody
    public int edit(SalChanceXm salChanceXm) {
        return saleBiz.edit(salChanceXm);
    }


    @RequestMapping("/kfcg")
    @ResponseBody
    public int kfcg(SalChanceXm salChanceXm) {
        int max = custBiz.selectCount() + 1;

        String smax = max + "";
        String sm = smax;
        for (int i = 0; i < 5 - smax.length(); i++) {
            sm = "0" + sm;
        }

        SalChanceXm chanceXm = saleBiz.load(salChanceXm);

        Customer customer = new Customer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        java.util.Date date = new java.util.Date();
        String time = sdf.format(date);

        customer.setCustNo("KH_" + time + "_" + sm);// 得到Id
        customer.setCustName(chanceXm.getChcCustName());
        customer.setCustManagerId(chanceXm.getChcDueId());
        customer.setCustManagerName(chanceXm.getChcDueTo());

        Orders orders = new Orders();
        orders.setOdrDate(new Date(new java.util.Date().getTime()));
        orders.setOdrStatus("b");
        orders.setOdrCustomer(chanceXm.getChcCustName());

        int q = custBiz.add(customer);
        int w = custBiz.add(orders);
        salChanceXm.setChcStatus("开发成功");
        int e = saleBiz.edit(salChanceXm);
        if (1 == q && 1 == w && e == 1) {
            return 1;
        } else {
            return 2;
        }
    }
}
