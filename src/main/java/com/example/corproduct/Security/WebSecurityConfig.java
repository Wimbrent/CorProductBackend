package com.example.corproduct.Security;

import com.example.corproduct.Security.JWT.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer {

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;
    @Resource
    UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()

                .authorizeRequests()

                .antMatchers("/api/v*/registration", "/api/v*/login").permitAll()

                .antMatchers("/**").permitAll().anyRequest().authenticated()

                .and().rememberMe().rememberMeParameter("remember-me")

                .and().addFilterBefore(authTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        httpSecurity.csrf().disable().cors().and().headers().frameOptions().disable();
        return httpSecurity.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
    @Bean
    public JwtAuthenticationFilter authTokenFilter() { return new JwtAuthenticationFilter(); }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")//allow all origins or set any origin you want
                .allowedMethods("*")//allow all methods or set any medhod
                .maxAge(3600)
                .allowedHeaders("*");//allow all headers or set any and header
    }
}