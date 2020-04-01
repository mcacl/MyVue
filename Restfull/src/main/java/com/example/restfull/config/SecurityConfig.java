package com.example.restfull.config;

import com.example.restfull.service.implserver.ImplLoginUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**1
 * 创建时间:2019/7/24
 * 创建人:pmc
 * 描述:
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private ImplLoginUserDetailsService implLoginUserDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(implLoginUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());//加密
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/static");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        //配置拦截规则----配置访问所有地址均需要ADMIN权限,使用内存用户使用hasAnyRole验证用户角色，使用数据库用户，使用hasAnyAuthority验证用户权限
        //http.authorizeRequests().antMatchers("/**").hasAnyAuthority("ADMIN");

        //配置登录页面及退出等相关页面
        http.formLogin().loginPage("/login")//登录页面
                .usernameParameter("loginname").passwordParameter("pas")//配置用户名密码参数名称
                .loginProcessingUrl("/login")//配置登录请求路径
                .defaultSuccessUrl("/main", true)//登录成功跳转,并且始终跳转到/main
                .failureUrl("/login")//登录失败跳转
                .and().logout().logoutUrl("/logout")//退出登录访问地址
                .logoutSuccessUrl("/login")//退出成功后访问页面
                .and().csrf().disable()//配置不进行csrf跨域拦截
                .headers().frameOptions().sameOrigin();//配置可以加载框架页面  如iframe
        //自动登录
        http.rememberMe().tokenValiditySeconds(3600 * 24 * 3);//设置cookie保存时间 单位秒
    }
}
