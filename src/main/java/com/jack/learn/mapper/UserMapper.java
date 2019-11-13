package com.jack.learn.mapper;

import com.jack.learn.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description
 * <p>
 * </p>
 * Date: 2017/7/26
 *
 * @author: 李伟健
 */
@Mapper
public interface UserMapper {

    List<User> selectUserByCondition(User user);

    Integer updateUserByPrimaryKey(User user);

    Integer deleteUserByPrimaryKey(Integer id);

    Integer insert(User user);
}
