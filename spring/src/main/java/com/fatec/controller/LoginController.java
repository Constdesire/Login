package com.fatec.controller;

import com.fatec.controller.adapter.LoginControllerAdapter;
import com.fatec.controller.dto.request.LoginRequest;
import com.fatec.controller.dto.response.LoginResponse;
import com.fatec.entity.Login;
import com.fatec.service.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logins")
public class LoginController {

    private final LoginService service;

    public LoginController(LoginService service) {
        this.service = service;
    }

    @PostMapping
    public LoginResponse criar(@RequestBody LoginRequest request) {
        Login loginParaSalvar = LoginControllerAdapter.castRequest(request);
        Login loginSalvo = service.salvar(loginParaSalvar);
        return LoginControllerAdapter.castResponse(loginSalvo);
    }

    @PutMapping("/{id}")
    public LoginResponse atualizar(@PathVariable String id, @RequestBody LoginRequest request) {
        Login loginParaAtualizar = LoginControllerAdapter.castRequest(request);
        return LoginControllerAdapter.castResponse(service.atualizar(id, loginParaAtualizar));
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable String id) {
        service.apagar(id);
    }

    @GetMapping
    public String realizarLogin() {
        return "realizar Login";
    }
}