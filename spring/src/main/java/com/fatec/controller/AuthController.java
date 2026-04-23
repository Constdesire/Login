package com.fatec.controller;

import com.fatec.controller.adapter.AuthControllerAdapter;
import com.fatec.controller.dto.request.LoginRequest;
import com.fatec.controller.dto.request.AuthRequest;
import com.fatec.controller.dto.response.AuthResponse;
import com.fatec.entity.Token;
import com.fatec.security.TokenSecurity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fatec/login")
public class AuthController {
    private final TokenSecurity tokenSecurity;

    public AuthController(TokenSecurity tokenSecurity) {
        this.tokenSecurity = tokenSecurity;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/v1/auth")
    public AuthResponse user(@RequestBody AuthRequest request) {
        Token token = tokenSecurity.gerarToken(AuthControllerAdapter.cast(request));
        return new AuthResponse(token.value());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/v1/auth/forget/{username}")
    public String forgetPassword(@PathVariable("username") String username) {
        return "Olá " + username + " enviamos sua senha para o seu email";
    }
}