package com.bufflabinc.test.login.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAfter(jwtAuthenticationFilter, LogoutFilter.class);

        http.authorizeRequests()
                .mvcMatchers("/", "/signup", "/access-denied", "/exception/**").permitAll()
                .mvcMatchers("/dashboard").hasRole("USER")
                .mvcMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .expressionHandler(configExpressionHandler());

        /**
         * 예외처리를 할 수 있는 부분 : 상황별 예외 처리 클래스를 지정한다.
         * authenticationEntryPoint() 로는 인증되지 않은 사용자가 인증이 필요한 URL에 접근하는 경우
         * accessDeniedHandler() 인증한 사용자가 추가 권한이 필요한 URL에 접근할 경우
         */
        http.exceptionHandling()
                .authenticationEntryPoint(configAuthenticationEntryPoint())
                .accessDeniedHandler(configAccessDeniedHandler());

        /**
         * OAuth2 로그인 관련 처리를 할 수 있다.
         * userService() Authentication생성에 필요한 OAuth2User 를 반환하는 클래스를 지정한다.
         * successHandler() 인증을 성공적으로 마친 경우 처리할 클래스를 지정한다.
         * failureHandler() 인증을 실패한 경우 처리할 클래스를 지정한다.
         */
        http.oauth2Login()
                .userInfoEndpoint().userService(customOAuth2UserService)
                .and()
                .successHandler(configSuccessHandler())
                .failureHandler(configFailureHandler())
                .permitAll();

        http.httpBasic();

        http.logout()
                .deleteCookies("JSESSIONID");
    }

    private AuthenticationFailureHandler configFailureHandler() {
    }

    private AuthenticationSuccessHandler configSuccessHandler() {
    }

    private AccessDeniedHandler configAccessDeniedHandler() {
    }

    private AuthenticationEntryPoint configAuthenticationEntryPoint() {
    }

    private SecurityExpressionHandler<FilterInvocation> configExpressionHandler() {
    }
}
