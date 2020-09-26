package com.gjsm.springboot_shiro.config;

import com.gjsm.springboot_shiro.shiro.realms.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Date on 2020/09/25  下午 08:37
 * 用户整合shiro框架相关的配置类
 */
@Configuration
public class ShiroConfig {
    //1.创建shiroFilter   负责拦截所有请求
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoyBean(DefaultWebSecurityManager defaultWebSecurityManager){
//        擦黄金shiro的filter
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        注入filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
//       配置系统受限资源
//        配置系统公共资源
        Map<String,String> map=new HashMap<String, String>();
        map.put("/user/login","anon");
        map.put("/register.jsp","anon");
        map.put("/user/register","anon");
        map.put("/**","authc");//authc请求这个资源需要认证和授权   anno都可以访问

        shiroFilterFactoryBean.setLoginUrl("/login.jsp");//默认认证界面路径，不写默认查找login.jsp
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }
    //2.创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        //给安全管理器设置
        defaultSecurityManager.setRealm(realm);

        return defaultSecurityManager;
    }

    //3.创建自定义realm
    @Bean
    public Realm getRealm(){

        CustomerRealm customerRealm = new CustomerRealm();
        HashedCredentialsMatcher credentialsMatcher=new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(1024);
        customerRealm.setCredentialsMatcher(credentialsMatcher);
        return customerRealm;
    }


}
