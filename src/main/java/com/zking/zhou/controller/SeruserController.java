package com.zking.zhou.controller;

import com.zking.zhou.biz.ISerUserZhouBiz;
import com.zking.zhou.model.SerUserZhou;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class SeruserController {

@Autowired
private ISerUserZhouBiz serUserZhouBiz;

@RequestMapping("/list")
@ResponseBody
public List<SerUserZhou> list(SerUserZhou suz){
    List<SerUserZhou> list=serUserZhouBiz.list(suz);
    return list;
}



}
