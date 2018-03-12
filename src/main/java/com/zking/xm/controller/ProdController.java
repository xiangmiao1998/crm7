package com.zking.xm.controller;

import com.zking.util.PageBean;
import com.zking.util.ResponseData;
import com.zking.xm.biz.IProdctBiz;
import com.zking.xm.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/prod")
public class ProdController {

    @Autowired
    private IProdctBiz prodctBiz;

    @RequestMapping("/toList")
    public String toList() {
        return "basd/product";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResponseData list(HttpServletRequest request, Product product) {
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<Product> list = prodctBiz.list(product, pageBean);
        ResponseData data = new ResponseData();
        data.setTotal(pageBean.getTotalRecord());
        data.setRows(list);
        return data;
    }

}
