package com.zksc.framework.Configuration;

import com.zksc.framework.Cache.RedisCacheManager;
import com.zksc.framework.Entity.SysResource;
import com.zksc.framework.Realm.MyRealm;
import com.zksc.framework.Service.SysResourceService;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShiroConfiguration {

    @Autowired
    private SysResourceService sysResourceService;

    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //设置shiro过滤器
        /*
            anon    无需认证
            authc   必须认证才能访问
            user    使用remerberMe功能才能访问
            permes  必须得到资源权限才行
            role    必须得到角色权限才行

         */
        Map<String, String> map = new LinkedHashMap<>();
        //一定要在前面，不让会拦截
        map.put("/user/login.do", "anon");
        //添加授权过滤器,授权拦截后会自动跳转到授权页面
        // map.put("/add.do", "perms[add]");
        List<SysResource> sysResourceList= sysResourceService.selectSysResourceList(new SysResource());

        for (SysResource sysResource : sysResourceList) {
            //添加权限
            map.put(sysResource.getResourceUrl(), "perms[" + sysResource.getResourcePermission() + "]");
            System.out.println("permisssion add success");
        }

        //map.put("/**", "authc");

        //修改跳转的登录页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin.action");

        //设置未授权跳转页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/auth.action");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }

    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getDeafultScurityManager(@Qualifier("myRealm") MyRealm myRealm) {

        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(myRealm);
        return defaultSecurityManager;
    }

    //获取Realm
    @Bean(name = "myRealm")
    public MyRealm getTestRealm(){
        MyRealm userRealm = new MyRealm();

        //开启缓存管理
        userRealm.setCacheManager(new RedisCacheManager());

        //开启全局缓存
        userRealm.setCachingEnabled(true);
        //开启认证缓存
        userRealm.setAuthenticationCachingEnabled(true);
        userRealm.setAuthenticationCacheName("AuthenticationCache");
        //开启授权缓存
        userRealm.setAuthorizationCachingEnabled(true);
        userRealm.setAuthorizationCacheName("AuthorizationCache");
        return userRealm;
    }
}
