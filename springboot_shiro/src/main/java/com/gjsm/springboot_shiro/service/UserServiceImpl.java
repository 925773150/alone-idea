package com.gjsm.springboot_shiro.service;

import com.gjsm.springboot_shiro.Utils.SaltUtils;
import com.gjsm.springboot_shiro.dao.UserDao;
import com.gjsm.springboot_shiro.entity.Role;
import com.gjsm.springboot_shiro.entity.User;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Date on 2020/09/26  下午 03:41
 */
@Service(value = "UserService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public void register(User user) {
        /*
        * 处理业务调用
        * 明文密码进行md5+salt+hash散列
        * 1.生成随机盐
        * 2.将随机盐报错数据库
        * */
        String salt = SaltUtils.getSalt(8);
        user.setSalt(salt);

        Md5Hash md5Hash=new Md5Hash(user.getPassword(),salt,1024);
        user.setPassword(md5Hash.toHex());
        userDao.save(user);
    }

    @Override
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public User findRoleByUserName(String username) {
        return userDao.findRoleByUserName(username);
    }
}
