package com.sporttrackback.domain.loginAndRegister;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface LoginAndRegisterRepository extends MongoRepository<User,String> {
    Optional<User> getByUsername(String username);

    Boolean existsByUsername(String username);
}
