package com.gjsm.springboot_shiro.service;

import com.gjsm.springboot_shiro.entity.Role;
import com.gjsm.springboot_shiro.entity.User;

import java.util.List;

/**
 * Date on 2020/09/26  下午 03:40
 */
public interface UserService {
    void register(User user);

    User findByUserName(String username);

    User findRoleByUserName(String username);
}
