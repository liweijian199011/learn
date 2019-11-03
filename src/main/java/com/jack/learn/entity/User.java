package com.jack.learn.entity;

import lombok.Data;

import java.util.Date;

/**
 * Description
 * <p>
 *     User
 * </p>
 * Date: 2017/7/26
 *
 * @author: 李伟健
 */
@Data
public class User {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别，1：男，2：女
     */
    private String phoneNumber;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
