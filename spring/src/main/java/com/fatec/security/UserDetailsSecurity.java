package com.fatec.security;

import com.fatec.entity.Login;
import com.fatec.repository.LoginRepository;
import com.fatec.security.dto.LoginUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsSecurity implements UserDetailsService {

    private final LoginRepository repository;

    public UserDetailsSecurity(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = repository.findByUsername(username);
        return new LoginUserDetails(login);
    }
}