package com.fatec.controller.adapter;

import com.fatec.controller.dto.request.LoginRequest;
import com.fatec.controller.dto.response.LoginResponse;
import com.fatec.entity.Login;
import com.fatec.entity.enumerable.UserRole;

import java.util.UUID;

public class LoginControllerAdapter {
    private LoginControllerAdapter() {
    }

    public static Login castRequest(LoginRequest request) {
        return new Login(
                UUID.randomUUID().toString(),
                request.username(),
                request.password(),
                request.roles()
        );
    }

    public static LoginResponse castResponse(Login login) {
        return new LoginResponse(
                login.id(),
                login.username(),
                login.roles()
        );
    }
}