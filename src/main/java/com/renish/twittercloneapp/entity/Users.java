package com.renish.twittercloneapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Users {

    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private String[ ] roles;
}
