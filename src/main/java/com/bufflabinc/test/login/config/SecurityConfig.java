package com.bufflabinc.test.login.config;

import com.bufflabinc.test.login.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;


@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
         * h2-console 화면을 보기 위해, 다음 옵션들을 disable 를 한다
         */
        http.csrf().disable()
                .headers().frameOptions().disable();

        /*
         * URL 별 권한 관리를 설정하는 옵션의 시작점
         */
        http.authorizeRequests()
                .antMatchers("/", "/api/hello", "/css/**", "/js/**", "/swagger-ui/**").permitAll()
                .antMatchers("/api/**", "/db").hasRole(Role.USER.name()) //hasRole(Role.USER.name())
                .anyRequest().authenticated();

        /*
         * 로그아웃 기능에 대한 설정
         */
        http.logout()
                .logoutSuccessUrl("/");

        /*
         * oauth2Login : OAuth2 로그인 기능에 대한 설정 진입점
         * userInfoEndPoint : OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정을 담당
         * userService : 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록한다.
         *                  리소스 서버에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있다.
         */
        http.oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);

    }

}
