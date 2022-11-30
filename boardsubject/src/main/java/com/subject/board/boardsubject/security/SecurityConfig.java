package com.subject.board.boardsubject.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MemberDetailsServiceImpl memberDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/", "/member/**", "/css/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN"); // 관리자만 접근 가능
        // 인증 필요시 로그인 페이지와 로그인 성공시 리다이렉팅 경로 지정
        http.formLogin().loginPage("/member/login").defaultSuccessUrl("/", true);
        // 로그인이 수행 될 uri 매핑 (post 요청이 기본)
        http.formLogin().loginProcessingUrl("/login").defaultSuccessUrl("/", true);
        // 인증된 사용자이지만 인가되지 않은 경로에 접근시 리다이렉팅 필요 uri 지정
        http.exceptionHandling().accessDeniedPage("/forbidden");
        // logout
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/");

        http.userDetailsService(memberDetailsService);

    }
}
