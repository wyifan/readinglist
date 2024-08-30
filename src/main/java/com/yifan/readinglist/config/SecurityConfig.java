package com.yifan.readinglist.config;

import com.yifan.readinglist.handler.ReadingUrlAuthenticationSuccessHandler;
import com.yifan.readinglist.services.ReadingUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 * package_name: com.yifan.readinglist.config
 * author: wyifa
 * date: 2024/8/29
 * description:
 * WebSecurityConfigurerAdapter is deprecated.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final ReadingUserDetailService readingUserDetailService;

    @Autowired
    public SecurityConfig(ReadingUserDetailService readingUserDetailService) {
        this.readingUserDetailService = readingUserDetailService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable) // springboot block post
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/home", "/register/**").permitAll();
                    registry.requestMatchers("/admin/**").hasRole("ADMIN");
                    registry.requestMatchers("/user/**").hasRole("USER");
                    registry.anyRequest().authenticated();
                })
                .formLogin(httpSecurityFormLoginConfigurer ->
                        httpSecurityFormLoginConfigurer
                                .loginPage("/login")
                                .successHandler(new ReadingUrlAuthenticationSuccessHandler())
                                .permitAll())
//                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }

//    @Bean
//    @ConditionalOnMissingBean()
//    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.builder()
//                .username("admin").password("$2a$12$S/jR8/4ECUeT0T6hTjHoJe2ml3U78ZBq3/H8D8jCaEqXcakA6p9aK")
//                .roles("ADMIN", "USER").build();
//        UserDetails user = User.builder()
//                .username("user").password("$2a$12$Wp.hnX80RlZxJczg2v4FLOktt.N1S.8CnKKHuZfKNG4ua4qDN71Ku")
//                .roles("USER").build();
//
//        return new InMemoryUserDetailsManager(admin, user);
//    }

    @Bean
    public UserDetailsService myUserDetailsService() {
        return readingUserDetailService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(readingUserDetailService);
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // https://bcrypt-generator.com/
        return new BCryptPasswordEncoder();
    }
}
