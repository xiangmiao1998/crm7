package com.zking.xm.biz;

import com.zking.util.PageBean;
import com.zking.xm.model.DictXm;

import java.util.List;

public interface IDictBiz {
    int add(DictXm dictXm);

    List<DictXm> list(DictXm dictXm, PageBean pageBean);

    int del(DictXm dictXm);

    DictXm load(DictXm dictXm);

    int edit(DictXm dictXm);
}
