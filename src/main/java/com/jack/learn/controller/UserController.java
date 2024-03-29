package com.jack.learn.controller;

//import com.dianping.cat.Cat;
//import com.dianping.cat.message.Event;
//import com.dianping.cat.message.Transaction;

import com.jack.learn.entity.User;
import com.jack.learn.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 * <p>
 *     用户接口
 * </p>
 * Date: 2017/7/26
 *
 * @author: 李伟健
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<?> listUser(UserPo userPo) {
        logger.info("开始查询用户信息, 查询条件：{}", userPo);
        return new ResponseEntity<>(userService.listUser(userPo),
                HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        logger.info("开始新增用户信息：{}", user);
        Integer result = 0;
        try {
            result = userService.addUser(user);
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}