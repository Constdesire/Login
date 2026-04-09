package com.fatec.repository;

import com.fatec.entity.Login;
import java.util.Optional;

public interface LoginRepository {
    Login save(Login login);
    Login update(String id, Login login);
    void delete(String id);
    Optional<Login> findById(String id);
}