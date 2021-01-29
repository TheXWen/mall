package com.xw.mall.service;

import com.xw.mall.pojo.User;
import com.xw.mall.vo.ResponseVo;

public interface IUserService {
    /**
     * 注册
     * @param user
     */
    ResponseVo<User> register(User user);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return ResponseVo
     */
    ResponseVo<User> login(String username, String password);
}
