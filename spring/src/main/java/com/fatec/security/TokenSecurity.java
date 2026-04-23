package com.fatec.security;

import com.fatec.entity.auth;
import com.fatec.entity.Token;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class TokenSecurity {
    private final JwtSecurity jwtSecurity;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;

    public TokenSecurity(
            JwtSecurity jwtSecurity,
            UserDetailsService userDetailsService,
            AuthenticationManager authenticationManager) {
        this.jwtSecurity = jwtSecurity;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }

    public Token gerarToken(auth auth) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
              auth.username(), auth.password());
        authenticationManager.authenticate(authToken);
        UserDetails userDetails = userDetailsService.loadUserByUsername(auth.username());
        return new Token(jwtSecurity.generateToken(userDetails));
    }
}