package com.renish.twittercloneapp.config.routerconfig;

import com.renish.twittercloneapp.config.handlerconfig.TwitterPostHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class TwitterPostRouter {

    @Autowired
    private TwitterPostHandler twitterPostHandler;

    @Bean
    public RouterFunction<ServerResponse> appRoutes() {
        return RouterFunctions.route()
                .GET("/twitter/posts", twitterPostHandler::getAllTwitterPost)
                .POST("/twitter/posts", twitterPostHandler::createTwitterPost)
                .PUT("/twitter/update/{id}", twitterPostHandler::updateTwitterPost)
                .DELETE("/twitter/delete/{id}", twitterPostHandler::deleteTwitterPost)
                .build();

    }
}
