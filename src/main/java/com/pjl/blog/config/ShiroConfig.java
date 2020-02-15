package com.pjl.blog.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author pjl
 * @create 2020-02-10-10:13
 */
@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean:3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro的内置过滤器

        //拦截
        Map<String, String> filterMap = new LinkedHashMap<>();

        filterMap.put("/admin/loginout","logout");
        filterMap.put("/admin/login","anon");
        filterMap.put("/admin/*", "authc");
        bean.setFilterChainDefinitionMap(filterMap);

        //设置登录请求
        bean.setLoginUrl("/admin");


        return bean;
    }


    //DefaultWebSecurityManager:2
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }


    //创建Realm对象，需要自定义类:1
    @Bean(name = "userRealm")
    public UserRealm userRealm() {
        return new UserRealm();
    }
}
