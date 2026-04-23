package com.fatec.controller.dto.request;
import com.fatec.entity.enumerable.UserRole;

import java.util.List;

public record LoginRequest(
        String username,
        String password,
        List<UserRole> roles)
{

}