package com.fatec.entity;

import com.fatec.entity.enumerable.UserRole;

import java.util.List;

public record Login(
        String id,
        String username,
        String password,
        List<UserRole> roles
) {
}