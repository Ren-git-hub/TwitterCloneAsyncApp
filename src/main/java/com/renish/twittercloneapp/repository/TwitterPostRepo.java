package com.renish.twittercloneapp.repository;

import com.renish.twittercloneapp.entity.TwitterPost;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterPostRepo extends ReactiveMongoRepository<TwitterPost, String> {
}
