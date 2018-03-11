package com.zking.xm.biz;

import com.zking.util.PageBean;
import com.zking.xm.model.SalPlanXm;

import java.util.List;

public interface ISalPlanBiz {
    List<SalPlanXm> list(SalPlanXm salPlanXm, PageBean pageBean);

    int add(SalPlanXm salPlanXm);

    int del(SalPlanXm salPlanXm);

    SalPlanXm load(SalPlanXm salPlanXm);

    int edit(SalPlanXm salPlanXm);
}
