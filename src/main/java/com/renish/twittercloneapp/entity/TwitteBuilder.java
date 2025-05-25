package com.renish.twittercloneapp.entity;

import org.springframework.stereotype.Component;

@Component
public class TwitteBuilder {

    private String id;
    private String title;
    private String body;
    private String author;

    public TwitteBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public TwitteBuilder setTitle(String title) {
        this.title = title;
        return this;
    }
    public TwitteBuilder setBody(String body) {
        this.body = body;
        return this;
    }
    public TwitteBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }
    public TwitterPost build() {
        TwitterPost twitterPost = new TwitterPost();
        twitterPost.setId(this.id);
        twitterPost.setTitle(this.title);
        twitterPost.setBody(this.body);
        twitterPost.setAuthor(this.author);
        return twitterPost;
    }


}
