package com.fatec.repository.orm;

import com.fatec.entity.Login;
import com.fatec.repository.LoginRepository;
import com.fatec.repository.adapter.LoginRepositoryAdapter;
import com.fatec.repository.mongo.LoginRepositoryWithMongoDB;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginRepositoryImpl implements LoginRepository {

    private final LoginRepositoryWithMongoDB mongo;

    public LoginRepositoryImpl(LoginRepositoryWithMongoDB mongo) {
        this.mongo = mongo;
    }

    @Override
    public Login save(Login login) {
        LoginOrmMongo orm = LoginRepositoryAdapter.castEntity(login);
        return LoginRepositoryAdapter.castOrm(mongo.save(orm));
    }

    @Override
    public Login update(String id, Login login) {
        LoginOrmMongo orm = new LoginOrmMongo(
                id,
                login.username(),
                login.password(),
                login.roles()
        );

        LoginOrmMongo ormSalvo = mongo.save(orm);

        return LoginRepositoryAdapter.castOrm(ormSalvo);
    }

    @Override
    public void delete(String id) {
        mongo.deleteById(id);
    }

    @Override
    public Optional<Login> findById(String id) {
        return mongo.findById(id).map(LoginRepositoryAdapter::castOrm);
    }
}