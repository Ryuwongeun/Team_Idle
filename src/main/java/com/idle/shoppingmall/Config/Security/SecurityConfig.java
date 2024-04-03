package com.idle.shoppingmall.Config.Security;


import com.idle.shoppingmall.Service.LoginService;
import com.idle.shoppingmall.Service.User.UserDetailService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.PrintWriter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final LoginService loginService;
    private final UserDetailService userDetailService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable) //csrf 설정 disable
                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
                                .requestMatchers("/api/GET/login").permitAll()
                                .requestMatchers("/api/POST/login").permitAll()
                                .requestMatchers("/api/GET/logout").permitAll()
                                .anyRequest().permitAll()
                )
                .formLogin((formLogin) ->
                        formLogin
                                .loginPage("/login") //로그인 화면 설정
                                .loginProcessingUrl("/api/POST/login") // login submit 요청을 받을 url
                                .successHandler(new CustomAuthenticationSuccessHandler(
                                        loginService
                                ))
                                .failureHandler(new CustomAuthenticationFailureHandler())
                                .failureUrl("/login") //로그인 실패시 이동할 url
                )
                .logout((logoutConfig)->
                        logoutConfig
                                .logoutUrl("/api/POST/logout")
                                .logoutSuccessUrl("/productList") //로그아웃 성공시 이동할 url
                                .addLogoutHandler(new CustomLogoutHandler())
                ).userDetailsService(userDetailService);
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
