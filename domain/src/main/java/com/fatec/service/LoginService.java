package com.fatec.service;

import com.fatec.entity.Login;
import com.fatec.repository.LoginRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class LoginService {
    private final LoginRepository repository;
    private final PasswordEncoder passwordEncoder;

    public LoginService(LoginRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Login salvar(Login login) {
        String senhaCriptografada = passwordEncoder.encode(login.password());
        Login loginCriptografado = new Login(
                login.id(),
                login.username(),
                senhaCriptografada,
                login.roles()
        );

        return repository.save(loginCriptografado);
    }

    public Login atualizar(String id, Login login) {
        String senhaCriptografada = passwordEncoder.encode(login.password());

        Login loginAtualizado = new Login(
                id,
                login.username(),
                senhaCriptografada,
                login.roles()
        );

        return repository.update(id, loginAtualizado);
    }

    public void apagar(String id) {
        repository.delete(id);
    }
}