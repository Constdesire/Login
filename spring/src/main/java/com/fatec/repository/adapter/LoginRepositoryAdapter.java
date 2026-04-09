package com.fatec.repository.adapter;

import com.fatec.entity.Login;
import com.fatec.repository.orm.LoginOrmMongo;

public class LoginRepositoryAdapter {

    private LoginRepositoryAdapter() {
    }

    public static Login castOrm(LoginOrmMongo orm) {
        return new Login(
                orm.id(),
                orm.username(),
                orm.password(),
                orm.roles()
        );
    }

    public static LoginOrmMongo castEntity(Login entity) {
        return new LoginOrmMongo(
                entity.id(),
                entity.username(),
                entity.password(),
                entity.roles()
        );
    }
}