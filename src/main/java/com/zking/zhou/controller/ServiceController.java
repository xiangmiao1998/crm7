package com.zking.zhou.controller;

import com.zking.util.PageBean;
import com.zking.util.ResponseData;
import com.zking.xm.model.UserXm;
import com.zking.zhou.biz.ISerSatisfzZhouBiz;
import com.zking.zhou.biz.ISerUserZhouBiz;
import com.zking.zhou.model.SerSatisftZhou;
import com.zking.zhou.model.SerUserZhou;
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
@RequestMapping("/service")
public class ServiceController {


@Autowired
private ISerSatisfzZhouBiz serSatisfzZhouBiz;
@Autowired
private ISerUserZhouBiz serUserZhouBiz;



    @RequestMapping("/toAdd")
    public String toAdd(){
        return "cust/service/add";
    }


    @RequestMapping("/toDispatch")
    public String toDispatch(){
        return "cust/service/dispatch";
    }

    //跳到任务分配界面显示所有
    @RequestMapping("/listDispatch")
    @ResponseBody
    public ResponseData listDispatch(SerSatisftZhou ssz, HttpServletRequest request){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        if(ssz.getSvrType()!=null&&ssz.getSvrType().equals("全部")){
            ssz.setSvrType(null);
        }
        if(ssz.getSvrStatus()!=null&&ssz.getSvrStatus().equals("全部")){
            ssz.setSvrStatus(null);
        }
        List<SerSatisftZhou> list=serSatisfzZhouBiz.list(pageBean,ssz);
        ResponseData data = new ResponseData();
        data.setTotal(pageBean.getTotalRecord());
        data.setRows(list);
        return data;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(SerSatisftZhou ssz, HttpSession session){
        UserXm u = (UserXm) session.getAttribute("user");
        long uid = u.getUsrId();
        ssz.setSvrCreateId(uid);
        ssz.setSvrStatus("新创建");
        ssz.setSvrCreateBy(u.getUsrName());
        ssz.setSvrCreateDate(new Date(new java.util.Date().getTime()));
        serSatisfzZhouBiz.add(ssz);
        return "aa";
    }


    @RequestMapping("/edit")
    @ResponseBody
    public int edit(SerSatisftZhou ssz){
        SerUserZhou suz = new SerUserZhou();
        suz.setUsrId(Integer.parseInt(ssz.getSvrDueId().toString()));
        suz=serUserZhouBiz.load(suz);
        ssz.setSvrId(ssz.getSvrId());
        ssz.setSvrDueTo(suz.getUsrName());
        ssz.setSvrDueDate(new Date(new java.util.Date().getTime()));
        ssz.setSvrStatus("已分配");
        return  serSatisfzZhouBiz.edit(ssz);

    }

    @RequestMapping("/del")
    @ResponseBody
    public void del(SerSatisftZhou ssz){
        serSatisfzZhouBiz.del(ssz);
    }

    @RequestMapping("/toDeal")
    public String toDeal(){
        return "cust/service/deal";
    }

    @RequestMapping("/loadDeal")
    @ResponseBody
    public SerSatisftZhou loadDeal(HttpServletRequest request,SerSatisftZhou ssz, Model model){
        SerSatisftZhou ssz1=serSatisfzZhouBiz.load(ssz);
        return ssz1;
    }

    @RequestMapping("/editDeal")
    @ResponseBody
    public int editDeal(SerSatisftZhou ssz,HttpServletRequest request){
        request.getParameter("SvrDeal");
        request.getParameter("svrDealBy");
        ssz.setSvrDealId(1L);
        ssz.setSvrStatus("已处理");
        ssz.setSvrDealDate(new Date(new java.util.Date().getTime()));
        System.out.println(ssz);
        return  serSatisfzZhouBiz.edit(ssz);
    }

    @RequestMapping("/toFeedback")
    public String toFeedback(){
        return "cust/service/feedback";
    }

    @RequestMapping("/loadFeedback")
    @ResponseBody
    public SerSatisftZhou loadFeedback(HttpServletRequest request,SerSatisftZhou ssz, Model model){
        SerSatisftZhou ssz1=serSatisfzZhouBiz.load(ssz);
        return ssz1;
    }

    @RequestMapping("/editFeedback")
    @ResponseBody
    public int editFeedback(SerSatisftZhou ssz,HttpServletRequest request){
        System.out.println(ssz.getSvrResult());
        System.out.println(ssz.getSvrStatus());
        ssz.setSvrStatus("已归档");
        ssz.setSvrDealDate(new Date(new java.util.Date().getTime()));
        return  serSatisfzZhouBiz.edit(ssz);
    }


    @RequestMapping("/toArch")
    public String toArch(){
        return "cust/service/arch";
    }

    @RequestMapping("/loadArch")
    @ResponseBody
    public SerSatisftZhou loadArch(HttpServletRequest request,SerSatisftZhou ssz, Model model){
        SerSatisftZhou ssz1=serSatisfzZhouBiz.load(ssz);
        return ssz1;
    }


}
