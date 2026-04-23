package com.fatec.repository;

import com.fatec.entity.Login;
import com.fatec.repository.adapter.LoginRepositoryAdapter;
import com.fatec.repository.mongo.LoginRepositoryWithMongoDB;
import com.fatec.repository.orm.LoginOrmMongo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
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

    @Override
    public Login findByUsername(String username) {
        try {

            Optional<LoginOrmMongo> optional = mongo.findByUsername(username);

            if (optional.isEmpty()) {
                throw new UsernameNotFoundException("Usuário não encontrado: " + username);
            }

            return LoginRepositoryAdapter.castOrm(optional.get());

        } catch (UsernameNotFoundException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("Erro técnico ao acessar o banco de dados", ex);
        }
    }
}