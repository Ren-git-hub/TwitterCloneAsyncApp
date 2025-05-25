package com.renish.twittercloneapp.service;

import com.renish.twittercloneapp.entity.TwitteBuilder;
import com.renish.twittercloneapp.entity.TwitterPost;
import com.renish.twittercloneapp.repository.TwitterPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TwitterPostService {

    @Autowired
    private TwitterPostRepo twitterPostRepo;

    public Flux<TwitterPost> getAllTwitterPosts() {
        return twitterPostRepo.findAll();
    }

    public Mono<TwitterPost> getTwitterPostById(String id) {
        return twitterPostRepo.findById(id);
    }

    public Mono<TwitterPost> saveTwitterPost(TwitterPost twitterPost) {
        return twitterPostRepo.save(twitterPost);
    }

    public Mono<TwitterPost> updateTwitterPost(TwitterPost twitterPost) {
       TwitterPost twitterPost1 = twitterPostRepo.findById(twitterPost.getId()).block();
       TwitteBuilder twitteBuilder = new TwitteBuilder();
       twitterPost1=twitteBuilder.setId(twitterPost1.getId())
                               .setTitle(twitterPost1.getTitle())
                               .setBody(twitterPost.getBody())
                               .setAuthor(twitterPost.getAuthor())
                               .build();
        return twitterPostRepo.save(twitterPost1);
    }

    public Mono<String> deleteTwitterPost(String id) {
        twitterPostRepo.deleteById(id);
        return Mono.just("Delete Successfully");

    }

}
