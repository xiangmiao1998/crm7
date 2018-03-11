package com.zking.xm.biz;

import com.zking.util.PageBean;
import com.zking.xm.model.SalChanceXm;

import java.util.List;

public interface ISaleBiz {
    int add(SalChanceXm salChanceXm);

    List<SalChanceXm> list(SalChanceXm salChanceXm, PageBean pageBean);

    int del(SalChanceXm salChanceXm);

    int edit(SalChanceXm salChanceXm);

    SalChanceXm load(SalChanceXm salChanceXm);
}
