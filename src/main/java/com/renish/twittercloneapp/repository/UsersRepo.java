package com.renish.twittercloneapp.repository;

import com.renish.twittercloneapp.entity.Users;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends ReactiveMongoRepository<Users, String> {
}
