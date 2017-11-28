package com.wacoal.dockeeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
    
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) 
//            throws Exception {
//        auth
//            .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
//    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
			.ldapAuthentication()
				.userDnPatterns("uid={0},ou=user")
//				.groupSearchBase("ou=groups")
				.contextSource()
					.url("ldap://10.11.9.135:389/dc=wacoal,dc=co,dc=th");
//                                        .managerPassword("1234567");
//					.and()
//                                       .passwordCompare()
//					.passwordEncoder(new PlaintextPasswordEncoder())
//					.passwordAttribute("userPassword");
//        auth
//                .ldapAuthentication()
//                .userDnPatterns("uid={0},ou=user")
//                .groupSearchBase("ou=user")
//                .contextSource()
//                .url("ldap://10.11.9.135:389/dc=wacoal,dc=co,dc=th")
//                .and()
//                .passwordCompare()
//                .passwordEncoder(new Md5PasswordEncoder())
//                .passwordAttribute("userPassword");
    }
}
