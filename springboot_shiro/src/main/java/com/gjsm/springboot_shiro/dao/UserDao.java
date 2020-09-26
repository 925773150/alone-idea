package com.gjsm.springboot_shiro.dao;

import com.gjsm.springboot_shiro.entity.Role;
import com.gjsm.springboot_shiro.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Date on 2020/09/26  下午 02:59
 */
@Repository
public interface UserDao {
    void save(User user);

    User findByUserName(String username);

    User findRoleByUserName(String username);
}
