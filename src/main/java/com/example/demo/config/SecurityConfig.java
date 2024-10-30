package com.example.demo.config;

import com.example.demo.security.JWTAuthehnticationEntryPoint;
import com.example.demo.security.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JWTAuthehnticationEntryPoint point;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
       try{
           httpSecurity.cors(cor->cor.disable())
                   .csrf(csrf->csrf.disable())
                   .authorizeHttpRequests(auth->auth.requestMatchers("/auth/login").permitAll()
                           .requestMatchers("/auth/getUser").authenticated()
                           .anyRequest().permitAll()

                   )
                   .exceptionHandling(exception->exception.authenticationEntryPoint(point))
                   .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
           httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

           return httpSecurity.build();
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }


    }


}
