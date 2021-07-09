package com.goaldae.book.springboot.config.auth;

import com.goaldae.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정들을 활성화시켜줌
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .headers().frameOptions().disable() //h2-console 화면을 사용하기 위해 해동 옵션 disable
            .and()
            .authorizeRequests() //URL별 권한 관리를 설정하는 옵션의 시작점
                //이 것이 선언되어야만 antMatchers옵션을 사용할 수 있음
            .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
            .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //권한 관리 대상을 지정하는 옵션
            .anyRequest().authenticated()//anyRequest: 설정된 값이외 나머지 URL 나타냄, authenticated는 인증된 사용자들에게만 허용함(로그인 한)
            .and()
            .logout()
            .logoutSuccessUrl("/") //로그아웃 성공시 / 주소로 이동
            .and()
            .oauth2Login()//OAuth2 로그인 기능에 대한 여러 설정의 진입점
            .userInfoEndpoint()//소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록
            .userService(customOAuth2UserService); //사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있음
    }
}
