package com.fatec.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(value = "login")
public record LoginOrmMongo(
        @Id
        String id,
        String username,
        String password,
        List<String> roles
) {
}