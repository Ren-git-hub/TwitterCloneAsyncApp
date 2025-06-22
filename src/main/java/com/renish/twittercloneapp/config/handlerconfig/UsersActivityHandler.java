package com.renish.twittercloneapp.config.handlerconfig;

import com.renish.twittercloneapp.entity.Users;
import com.renish.twittercloneapp.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class UsersActivityHandler {

    @Autowired
    private UsersRepo usersRepo;

    public Mono<ServerResponse> signUp(ServerRequest request) {
        return request.bodyToMono(Users.class)
                .flatMap(users -> usersRepo.save(users))
                .flatMap(savedUser -> ServerResponse.ok().body(Mono.just(savedUser), Users.class))
                .onErrorResume(throwable -> ServerResponse.status(500).body(Mono.just("Error while saving user"), String.class));
    }

    public Mono<ServerResponse> signIn(ServerRequest request) {
        return request.bodyToMono(Users.class)
                .flatMap(users -> ServerResponse.ok().body(Mono.just("login successful "), String.class));
    }
}
