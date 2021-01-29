package com.xw.mall.service.impl;

import com.xw.mall.MallApplicationTests;
import com.xw.mall.enums.ResponseEnum;
import com.xw.mall.enums.RoleEnum;
import com.xw.mall.pojo.User;
import com.xw.mall.service.IUserService;
import com.xw.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImplTest extends MallApplicationTests {

    public static final String USERNAME = "jack";

    public static final String PASSWORD = "123456";

    @Autowired
    private IUserService userService;

    @Before
    public void register() {
        userService.register(new User("jack", "123456", "jack@qq.com", RoleEnum.CUSTOMER.getCode()));
    }

    @Test
    public void login() {
        ResponseVo<User> responseVo = userService.login(USERNAME, PASSWORD);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}