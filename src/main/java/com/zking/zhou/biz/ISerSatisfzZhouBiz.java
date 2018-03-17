package com.zking.zhou.biz;


import com.zking.util.PageBean;
import com.zking.zhou.model.SerSatisftZhou;

import java.util.List;

public interface ISerSatisfzZhouBiz {

    void add(SerSatisftZhou ssz);

    List<SerSatisftZhou> list(PageBean pageBean, SerSatisftZhou ssz);

    int edit(SerSatisftZhou ssz);

    void del(SerSatisftZhou ssz);

    SerSatisftZhou load(SerSatisftZhou ssz);
}
