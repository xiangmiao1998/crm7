package com.zking.xm.controller;

import com.zking.util.PageBean;
import com.zking.util.ResponseData;
import com.zking.xm.biz.ISaleBiz;
import com.zking.xm.biz.IUserBiz;
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
import java.util.List;

@Controller
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private ISaleBiz saleBiz;

    @Autowired
    private IUserBiz userBiz;

    @RequestMapping("/tolist")
    public String toList() {
        return "sale/list";
    }

    @RequestMapping("/devlist")
    public String devList() {
        return "/sale/dev";
    }

    @RequestMapping("/listSale")
    @ResponseBody
    public ResponseData listSale(HttpServletRequest request, SalChanceXm salChanceXm) {
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<SalChanceXm> chanceXmList = saleBiz.list(salChanceXm, pageBean);
        ResponseData data = new ResponseData();
        data.setTotal(pageBean.getTotalRecord());
        data.setRows(chanceXmList);
        return data;
    }


    @RequestMapping("/addSale")
    @ResponseBody
    public int add(SalChanceXm salChanceXm) {
        salChanceXm.setChcCreateId(1l);
        salChanceXm.setChcCreateBy("刘颖");
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

        return 1;
    }
}
