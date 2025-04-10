package com.quanxiaoha.weblog.admin.config;

import com.quanxiaoha.weblog.jwt.config.JwtAuthenticationSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationSecurityConfig jwtAuthenticationSecurityConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(). // 禁用 csrf
                formLogin().disable() // 禁用表单登录
                .apply(jwtAuthenticationSecurityConfig) // 设置用户登录认证相关配置
                .and()
                .authorizeHttpRequests()
                .mvcMatchers("/admin/**").authenticated() // 认证所有以 /admin 为前缀的 URL 资源
                .anyRequest().permitAll() // 其他都需要放行，无需认证
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 前后端分离，无需创建会话
    }
}
// 上述代码中，在 configure() 方法中，首先禁用了 CSRF（Cross-Site Request Forgery）攻击防
// 护。在前后端分离的情况下，通常不需要启用 CSRF 防护。同时，还禁用了表单登录，并应用了 JWT
// 相关的配置类 JwtAuthenticationSecurityConfig。最后，配置会话管理这块，将会话策略设置
// 为无状态（STATELESS），适用于前后端分离的情况，无需创建会话。
