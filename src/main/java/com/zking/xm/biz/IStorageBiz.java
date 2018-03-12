package com.zking.xm.biz;

import com.zking.util.PageBean;
import com.zking.xm.model.Storage;

import java.util.List;

public interface IStorageBiz {
    List<Storage> list(Storage storage, PageBean pageBean);
}
