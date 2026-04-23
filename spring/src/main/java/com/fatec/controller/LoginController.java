package com.fatec.controller;

import com.fatec.controller.adapter.LoginControllerAdapter;
import com.fatec.controller.dto.request.LoginRequest;
import com.fatec.controller.dto.response.LoginResponse;
import com.fatec.entity.Login;
import com.fatec.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fatec/login")
public class LoginController {
    private final LoginService service;

    public LoginController(LoginService service) {
        this.service = service;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/v1/save")
    public LoginResponse save(@RequestBody LoginRequest request) {
        Login save = service.salvar(LoginControllerAdapter.castRequest(request));
        return new LoginResponse(
                save.id(),
                save.username(),
                save.roles()
        );
    }

    @GetMapping("/v1/validar-acesso")
    public String validar() {
        return "Acesso autorizado! O Token JWT funciona.";
    }

}