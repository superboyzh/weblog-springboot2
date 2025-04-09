package com.quanxiaoha.weblog.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .mvcMatchers("/admin/**").authenticated() // 认证所有以 /admin 为前缀的 URL 资源
                .anyRequest().permitAll().and() // 其他都需要放行，无需认证
                .formLogin().and() // 使用表单登录
                .httpBasic(); // 使用 HTTP Basic 认证
    }
}
// 上述代码中，我们重写了 configure() 方法，在该方法中，指定了对所有以 /admin 为前缀的请
// 求需要进行安全认证，另外，对其他请求均放行，无需认证，因为博客前台的页面是任何人都可以访问
// 的。最后，通过 formLogin() 方法指定使用表单登录，并使用 使用 HTTP Basic 认证。
