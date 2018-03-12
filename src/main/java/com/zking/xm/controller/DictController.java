package com.zking.xm.controller;

import com.zking.util.PageBean;
import com.zking.util.ResponseData;
import com.zking.xm.biz.IDictBiz;
import com.zking.xm.model.DictXm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;

@Controller
@RequestMapping("/dict")
public class DictController {

    @Autowired
    private IDictBiz dictBiz;

    @RequestMapping("/toList")
    public String toList() {
        return "basd/dict";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "basd/dict_add";
    }

    @RequestMapping("/add")
    @ResponseBody
    public int addDict(Model model, DictXm dictXm) {
        return dictBiz.add(dictXm);
    }

    @RequestMapping("/listDict")
    @ResponseBody
    public ResponseData listDict(HttpServletRequest request, DictXm dictXm) {
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<DictXm> dictXmList = dictBiz.list(dictXm, pageBean);
        ResponseData data = new ResponseData();
        data.setTotal(pageBean.getTotalRecord());
        data.setRows(dictXmList);
        return data;
    }


    @RequestMapping("/list")
    @ResponseBody
    public List<DictXm> list(DictXm dictXm) {
        return dictBiz.list(dictXm, null);
    }

    @RequestMapping("/loaddict")
    @ResponseBody
    public DictXm loadDict(DictXm dictXm) {
        return dictBiz.load(dictXm);
    }

    @RequestMapping("/deldict")
    @ResponseBody
    public int delDict(HttpServletRequest request, DictXm dictXm) {
        return dictBiz.del(dictXm);
    }

    @RequestMapping("/editdict")
    @ResponseBody
    public int editDict(DictXm dictXm) {
        return dictBiz.edit(dictXm);
    }
}
