package com.xw.mall.service.impl;

import com.xw.mall.dao.UserMapper;
import com.xw.mall.enums.RoleEnum;
import com.xw.mall.pojo.User;
import com.xw.mall.service.IUserService;
import com.xw.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

import static com.xw.mall.enums.ResponseEnum.*;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVo<User> register(User user) {
        //username不能重复
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername != 0) {
            return ResponseVo.error(USERNAME_EXIST);
        }

        //email不能重复
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if (countByEmail != 0) {
            return ResponseVo.error(EMAIL_EXIST);
        }

        user.setRole(RoleEnum.CUSTOMER.getCode());
        //MD5摘要算法
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));

        //写入数据库
        int resultCount = userMapper.insertSelective(user);
        if (resultCount == 0) {
            return ResponseVo.error(ERROR);
        }

        return ResponseVo.success();
    }

    @Override
    public ResponseVo<User> login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user == null || !user.getPassword().equalsIgnoreCase(DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))) {
            return ResponseVo.error(USERNAME_OR_PASSWORD_ERROR);
        }

        user.setPassword("");
        return ResponseVo.success(user);
    }
}
