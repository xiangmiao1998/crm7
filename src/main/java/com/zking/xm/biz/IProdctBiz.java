package com.zking.xm.biz;

import com.zking.util.PageBean;
import com.zking.xm.model.Product;

import java.util.List;

public interface IProdctBiz {

    List<Product> list(Product product, PageBean pageBean);
}
