/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 *
 * @author longt
 */
@Configuration
@EnableWebSecurity
public class MultiHttpSecurityConfig {

    @Autowired
    private DataSource myDataSource;

    @Bean
    public UserDetailsManager userDetailsManager() {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();

        jdbcUserDetailsManager.setDataSource(myDataSource);

        return jdbcUserDetailsManager;
    }

    @Configuration
    @Order(1)
    public class ConfigSecurityAppAdmin extends WebSecurityConfigurerAdapter {

        public ConfigSecurityAppAdmin() {
            super();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.jdbcAuthentication().dataSource(myDataSource)
                    .usersByUsernameQuery("select taiKhoan as username, password, status from TaiKhoan where taiKhoan=?")
                    .authoritiesByUsernameQuery("select taiKhoan as username, role from TaiKhoan where taiKhoan=?");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/ADMIN/**")
                    .authorizeRequests()
                    .antMatchers("/ADMIN/books/**").hasAnyRole("SELLER", "ADMIN")
                    .anyRequest()
                    .hasAnyRole("ADMIN")
                    .and()
                    .formLogin()
                    .loginPage("/ADMIN/login")
                    .defaultSuccessUrl("/ADMIN/books")
                    .loginProcessingUrl("/ADMIN/perform_login")
                    .permitAll()
                    .and()
                    .logout()
                    .logoutUrl("/ADMIN/logoutAdmin")
                    .logoutSuccessUrl("/ADMIN/login")
                    .deleteCookies("JSESSIONID")
                    .permitAll()
                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("/accessDeniedPage");
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring()
                    .antMatchers("/Resources/**")
                    .antMatchers("/Photo-BaiTapLon/**")
                    .antMatchers("/Image-BaiTapLon/**");
        }
    }

    @Configuration
    @Order(2)
    public class ConfigSecurityApp extends WebSecurityConfigurerAdapter {

        public ConfigSecurityApp() {
            super();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.jdbcAuthentication().dataSource(myDataSource)
                    .usersByUsernameQuery("select taiKhoan as username, password, status from TaiKhoan where taiKhoan=?")
                    .authoritiesByUsernameQuery("select taiKhoan as username, role from TaiKhoan where taiKhoan=?");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/**")
                    .authorizeRequests()                    
                    .antMatchers("/").permitAll()
                    .antMatchers("/home").permitAll()
                    .antMatchers("/accessDeniedPage").permitAll()
                    .antMatchers("/register/**").permitAll()
                    .antMatchers("/photo/**").permitAll()
                    .antMatchers("/image/**").permitAll()
                    .antMatchers("/about").permitAll()
                    .antMatchers("/sach/**").permitAll()
                    .antMatchers("/contact").permitAll()
                    .antMatchers("/profile/**").hasAnyRole("CUSTOMER", "ADMIN", "SELLER")
                    .antMatchers("/cart/**").hasAnyRole("CUSTOMER", "ADMIN", "SELLER")
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/loginPage")
                    .loginProcessingUrl("/perform_login")
                    .permitAll()
                    .and()
                    .logout()
                    .logoutSuccessUrl("/")
                    .deleteCookies("JSESSIONID")
                    .permitAll()
                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("/accessDeniedPage");
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring()
                    .antMatchers("/Resources/**")
                    .antMatchers("/Photo-BaiTapLon/**")
                    .antMatchers("/Image-BaiTapLon/**");
        }
    }

}
