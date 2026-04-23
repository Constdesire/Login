package com.fatec.controller.dto.response;
import com.fatec.entity.enumerable.UserRole;

import java.util.List;

public record LoginResponse(
        String id,
        String username,
        List<UserRole> roles)
{

}