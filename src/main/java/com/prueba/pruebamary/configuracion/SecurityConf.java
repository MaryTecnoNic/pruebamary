package com.prueba.pruebamary.configuracion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConf {

    @Value("${usrApli}")
    private String usrAplicacion;

    @Value("${clsApli}")
    private String clsAplicacion;

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username(usrAplicacion)
                .password(clsAplicacion)
                .roles("ADMIN")
                .build();

        return  new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf()
                .disable()
                .authorizeRequests()
//                .antMatchers("/swagger").denyAll()
                .antMatchers("/**")
                .authenticated()
                .and()
                .httpBasic(Customizer.withDefaults())
                .build();

    }
}
