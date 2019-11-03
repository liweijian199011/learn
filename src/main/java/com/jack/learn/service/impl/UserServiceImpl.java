package com.jack.learn.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.example.h2demo.controller.UserPo;
import com.example.h2demo.dao.UserMapper;
import com.example.h2demo.entity.User;
import com.example.h2demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description
 * <p>
 * </p>
 * Date: 2017/7/26
 *
 * @author: 李伟健
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUser(UserPo userPo) {
        User user = new User();
        BeanUtils.copyProperties(userPo, user);
        return userMapper.selectList(new Wrapper<User>() {
            @Override
            public User getEntity() {
                return user;
            }

            @Override
            public MergeSegments getExpression() {
                return null;
            }

            @Override
            public String getCustomSqlSegment() {
                return null;
            }

            @Override
            public String getSqlSegment() {
                return null;
            }
        });
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public Integer updateUserById(User user) {
        return userMapper.updateById(user);
    }
}
