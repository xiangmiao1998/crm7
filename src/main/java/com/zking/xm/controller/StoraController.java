package com.zking.xm.controller;

import com.zking.util.PageBean;
import com.zking.util.ResponseData;
import com.zking.xm.biz.IStorageBiz;
import com.zking.xm.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/stor")
public class StoraController {

    @Autowired
    private IStorageBiz storageBiz;

    @RequestMapping("/toList")
    public String toList() {
        return "basd/storage";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResponseData list(HttpServletRequest request, Storage storage) {
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<Storage> list = storageBiz.list(storage, pageBean);
        for (Storage s : list) {
            s.setpName(s.getProduct().getProdName());
        }
        ResponseData data = new ResponseData();
        data.setTotal(pageBean.getTotalRecord());
        data.setRows(list);
        return data;
    }
}
