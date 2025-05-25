package com.renish.twittercloneapp.config.handlerconfig;

import com.renish.twittercloneapp.entity.TwitterPost;
import com.renish.twittercloneapp.repository.TwitterPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TwitterPostHandler {

    @Autowired
    TwitterPostRepo twitterPostRepo;

    public Mono<ServerResponse> getAllTwitterPost(ServerRequest request) {
        Flux<TwitterPost> twitterPostFlux = twitterPostRepo.findAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(twitterPostFlux, TwitterPost.class);
    }

    public Mono<ServerResponse> createTwitterPost(ServerRequest request) {
       return  request.bodyToMono(TwitterPost.class)
               .flatMap(twitterPost -> twitterPostRepo.save(twitterPost))
               .flatMap(saved -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just(saved), TwitterPost.class))
               .switchIfEmpty(ServerResponse.notFound().build())
               .onErrorResume(throwable -> ServerResponse.status(500).body(Mono.just("Error while creating"),Throwable.class));

    }

    public Mono<ServerResponse> updateTwitterPost(ServerRequest request) {
        String id = request.pathVariable("id");
        return request.bodyToMono(TwitterPost.class)
                .flatMap(updatepost -> twitterPostRepo.save(updatepost))
                .flatMap(saved -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just(saved), TwitterPost.class))
                .onErrorResume(throwable -> ServerResponse.status(500).body(Mono.just("Error while updating"),Throwable.class));
    }

    public Mono<ServerResponse> deleteTwitterPost(ServerRequest request) {
        twitterPostRepo.deleteById(request.pathVariable("id"));
        return ServerResponse.ok().body(Mono.just("Deleted post"),String.class);
    }
}
