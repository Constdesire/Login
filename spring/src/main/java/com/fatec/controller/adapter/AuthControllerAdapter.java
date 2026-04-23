package com.fatec.controller.adapter;

import com.fatec.controller.dto.request.AuthRequest;
import com.fatec.entity.auth;

public class AuthControllerAdapter {
    private AuthControllerAdapter() {
    }

    public static auth cast(AuthRequest request) {
        return new auth(request.username(), request.password());
    }
}