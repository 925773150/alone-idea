package com.gjsm.springboot_shiro.shiro.realms;

import com.gjsm.springboot_shiro.entity.Role;
import com.gjsm.springboot_shiro.entity.User;
import com.gjsm.springboot_shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * Date on 2020/09/25  下午 08:45
 * 自定义realm
 */
public class CustomerRealm extends AuthorizingRealm {

    /*授权*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        获取身份信息
        String  primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        System.out.println("调用授权验证"+primaryPrincipal);
//       根据主身份信息获取角色和权限信息
        UserService userService = (UserService) ApplicationContextUtils.getBean("UserService");
        User user = userService.findRoleByUserName(primaryPrincipal);
//        授权角色信息
        if(!CollectionUtils.isEmpty(user.getRoleList())){
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            user.getRoleList().forEach(role -> {
                simpleAuthorizationInfo.addRole(role.getName());
            });
            return simpleAuthorizationInfo;
        }


        return null;
    }

    /*认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        UserService userService = (UserService) ApplicationContextUtils.getBean("UserService");
        User user = userService.findByUserName(principal);
        if(!ObjectUtils.isEmpty(user)){
            return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName());
        }

        if("xiaochen".equals(principal)){
            return new SimpleAuthenticationInfo(principal,"123",this.getName());
        }
        return null;
    }
}
