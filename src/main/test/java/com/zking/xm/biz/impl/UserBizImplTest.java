package com.zking.xm.biz.impl;

import com.zking.xm.biz.IUserBiz;
import com.zking.xm.model.UserXm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class UserBizImplTest {

    @Autowired
    private IUserBiz userBiz;

    private UserXm userXm;

    @Before
    public void setUp() throws Exception {
        userXm = new UserXm();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void list() throws Exception {
//        List<UserXm> list = userBiz.list(userXm);
//        for (UserXm u: list) {
//            System.out.println(u);
//        }
//        String aa = "fff-000001";
//        String cc = aa.substring(5);
//        System.out.println(cc);
//        Integer bb = Integer.parseInt(cc);
//        System.out.println(bb+100);

        int a= 111;
        String aa = a+"";
        System.out.println(aa.length());
        String bb = aa;
        for (int i=0;i<6-aa.length();i++) {
            bb = "0" + bb;
            System.out.println(bb);
        }
        System.out.println(bb);
    }

}