package com.wei.config.shiro;

import com.wei.exception.MyExceptionHandler;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @Author:weipemng
 * @Desicription: shiro 配置
 * @Date:Created on 2018/7/9.
 * @Modified By:
 */
@Configuration
public class ShiroConfiguration {
    @Value("${spring.redis.shiro.host}")
    private String host;
    @Value("${spring.redis.shiro.port}")
    private int port;
    @Value("${spring.redis.shiro.timeout}")
    private int timeout;
    @Value("${spring.redis.shiro.password}")
    private String password;
    @Value("${spring.redis.shiro.expire}")
    private String expire;
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, String> map = new LinkedHashMap<String, String>();
        //        三种方式实现定义权限路径
//        第一种:使用角色名定义
//        map.put("/**/**", "authc, roles[admin]");

//        第二种:使用权限code定义
//        map.put("/api/update", "authc, perms[UPDATE]");//对于restful接口 最好不要在这里定义，因为一个链接可以有不同的请求方式
//        map.put("/api/delete", "authc, perms[DELETE]");
//        map.put("/api/add", "authc, perms[ADD]");

        // 配置不需要登录认证的链接 顺序判断
        map.put("/api/selectUser","anon");
        map.put("/static/**", "anon");
        map.put("/api/login", "anon");
        map.put("/swagger-ui.html/**", "anon");
        map.put("/swagger-resources/**", "anon");
        map.put("/v2/**", "anon");
        map.put("/webjars/**", "anon");
        map.put("/403", "anon");
        //登出,shiro已经实现
        map.put("/logout", "logout");
        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问 使用@RequiresPermissions("")配置接口权限-->
        map.put("/**", "authc");

//        设置登录url，，未登录时请求的
        shiroFilterFactoryBean.setLoginUrl("/unauth");
//        登录成功后要跳转的链接
//        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权跳转页面，但是用注解RequiresPermissions配置的权限不通过会抛出AuthorizationException异常，并不会跳转，需要做相应的异常处理
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    /**
     * 凭证匹配器
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * ）
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
        return hashedCredentialsMatcher;
    }

    @Bean
    public ShirRealm myShiroRealm() {
        ShirRealm myShirRealm = new ShirRealm();
        myShirRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShirRealm;
    }


    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        // 自定义session管理 使用redis
        securityManager.setSessionManager(sessionManager());
        // 自定义缓存实现 使用redis
        securityManager.setCacheManager(cacheManager());
        return securityManager;
    }

    //自定义sessionManager
    @Bean
    public SessionManager sessionManager() {
        MyShiroSessionManager mySessionManager = new MyShiroSessionManager();
        mySessionManager.setSessionDAO(redisSessionDAO());
        return mySessionManager;
    }

    /**
     * 配置shiro redisManager
     * <p>
     * 使用的是shiro-redis开源插件
     *
     * @return
     */
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setExpire(Integer.parseInt(expire));// 配置缓存过期时间
        redisManager.setTimeout(timeout);
        redisManager.setPassword(password);
        return redisManager;
    }

    /**
     * cacheManager 缓存 redis实现
     * <p>
     * 使用的是shiro-redis开源插件
     *
     * @return
     */
    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }

    /**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis
     * <p>
     * 使用的是shiro-redis开源插件
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }

    /**
     * 开启shiro aop注解支持.
     * 使用代理方式;所以需要开启代码支持;
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 注册全局异常处理
     * @return
     */
    @Bean(name = "exceptionHandler")
    public HandlerExceptionResolver handlerExceptionResolver() {
        return new MyExceptionHandler();
    }


}
