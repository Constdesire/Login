package com.fatec.config;

import com.fatec.repository.LoginRepository;
import com.fatec.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginServiceConfig {

    @Bean
    public LoginService loginService(LoginRepository loginRepository) {
        return new LoginService(loginRepository);
    }
}