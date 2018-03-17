package com.zking.zhou.biz;

import com.zking.zhou.model.SerUserZhou;

import java.util.List;

public interface ISerUserZhouBiz {

    List<SerUserZhou> list(SerUserZhou suz);

    SerUserZhou load(SerUserZhou suz);

}
