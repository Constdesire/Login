package com.fatec.service;

import com.fatec.entity.Login;
import com.fatec.repository.LoginRepository;

public class LoginService {
    private final LoginRepository repository;

    public LoginService(LoginRepository repository) {
        this.repository = repository;
    }
    public Login salvar(Login login) {
        return repository.save(login);
    }
    public Login atualizar(String id, Login login) {
        return repository.update(id, login);
    }
    public void apagar(String id) {
        repository.delete(id);
    }
}

