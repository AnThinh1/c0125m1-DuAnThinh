package com.codegym.commencalstore.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Phần dành cho admin
                        .requestMatchers("/bikes/add", "/bikes/edit/**","/orders/list")
                        .authenticated() // Chỉ admin mới truy cập
                        // Phần cho khách (ai cũng vào được)
                        .requestMatchers(  "/bikes", "/orders","/orders/checkout-form" , "/success", "/css/**", "/js/**")
                        .permitAll()
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")        // URL hiển thị form đăng nhập
                        .loginProcessingUrl("/login") // nơi form POST đến
                        .defaultSuccessUrl("/bikes", true) // trang chuyển hướng sau khi đăng nhập thành công
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/bikes")
                        .permitAll()
                )

                .csrf(csrf -> csrf.disable()); // nếu mi đang test, có thể tắt tạm

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}123456") // {noop} để không mã hoá
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }
}
