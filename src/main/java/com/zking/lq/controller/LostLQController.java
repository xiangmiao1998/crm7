package com.zking.lq.controller;

import com.zking.lq.biz.ICustomerLQBiz;
import com.zking.lq.biz.ILostLQBiz;
import com.zking.lq.model.CustomerLQ;
import com.zking.lq.model.LostLQ;
import com.zking.lq.model.OrdersLQ;
import com.zking.util.PageBean;
import com.zking.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/lostLQ")
public class LostLQController {

    @Autowired
    private ILostLQBiz lostLQBiz;
    @Autowired
    private ICustomerLQBiz customerLQBiz;

    private LostLQ lostLQ;
    private CustomerLQ customerLQ;

    //标识非请求方法
    @ModelAttribute
    public void init(Model model){
        lostLQ = new LostLQ();
        customerLQ=new CustomerLQ();
    }

    @RequestMapping("/look")
    public String look(){
        return "cust/lost/list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResponseData list(HttpServletRequest request,LostLQ lostLQ){
        System.out.println("客户："+lostLQ.getLstCustName());
        System.out.println("经理：" + lostLQ.getLstCustManagerName());
        System.out.println("状态：" + lostLQ.getLstStatus());
        PageBean pageBean = new PageBean();
        pageBean.setRequest(request);
        List<LostLQ> lostLQList = lostLQBiz.list(lostLQ, pageBean);
        for(LostLQ lost:lostLQList){
            if("1".equals(lost.getLstStatus())){
                lost.setStatus("预警");
            }else if("2".equals(lost.getLstStatus())){
                lost.setStatus("暂缓流失");
            }else if("3".equals(lost.getLstStatus())){
                lost.setStatus("确认流失");
            }else{
                lost.setStatus("暂缓客户流失成功");
            }
        }
        ResponseData date = new ResponseData();
        date.setTotal(pageBean.getTotalRecord());
        date.setRows(lostLQList);
        return date;
    }




    @RequestMapping("/loadBylstId")
    @ResponseBody
    public LostLQ loadBylstId(LostLQ lostLQ){
        LostLQ lost = lostLQBiz.loadBylstId(lostLQ);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String time1 = sf.format(lost.getLstLastOrderDate());
        lost.setTime1(time1);
        return lost;
    }

    @RequestMapping("/edit1")
    @ResponseBody
    public int edit1(LostLQ lostLQ){
        LostLQ lost = lostLQBiz.loadBylstId(lostLQ);
        //假删除
        customerLQ.setCustNo(lost.getLstCustNo());
        CustomerLQ cust = customerLQBiz.loadBycustNo(customerLQ);
        cust.setCustStatus("4");
        customerLQBiz.edit(cust);

        lostLQ.setLstDelay(lost.getLstDelay());
        lostLQ.setLstLastOrderDate(lost.getLstLastOrderDate());
        lostLQ.setLstStatus("3");
        if("".equals(lost.getLstLostDate())||null==lost.getLstLostDate()){
            lostLQ.setLstLostDate(new Date());
        }else{
            lostLQ.setLstLostDate(lost.getLstLostDate());
        }
        int row = lostLQBiz.edit(lostLQ);
        return  row;
    }

    @RequestMapping("/edit2")
    @ResponseBody
    public int edit2(LostLQ lostLQ){
        LostLQ lost = lostLQBiz.loadBylstId(lostLQ);

        customerLQ.setCustNo(lost.getLstCustNo());
        CustomerLQ cust = customerLQBiz.loadBycustNo(customerLQ);
        cust.setCustStatus("2");
        customerLQBiz.edit(cust);

        lostLQ.setLstLastOrderDate(lost.getLstLastOrderDate());
        lostLQ.setLstStatus("2");
        lostLQ.setLstDelay(lostLQ.getLstDelay()+lostLQ.getZhuijia());
        int row = lostLQBiz.edit(lostLQ);
        return  row;
    }




}
