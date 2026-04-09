package com.fatec.repository.mongo;

import com.fatec.repository.orm.LoginOrmMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginRepositoryWithMongoDB extends MongoRepository<LoginOrmMongo, String> {
}