package com.fatec.config;

import com.fatec.repository.LoginRepository;
import com.fatec.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class LoginServiceConfig {

    @Bean
    public LoginService loginService(LoginRepository loginRepository, PasswordEncoder passwordEncoder) {
        return new LoginService(loginRepository, passwordEncoder);
    }
}