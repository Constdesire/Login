package com.fatec.controller.dto.request;

public record AuthRequest(
        String username,
        String password
) {
}