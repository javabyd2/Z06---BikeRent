package com.sda.spring.bikeRent.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private String userLastName;
    private String email;
    private String password;

    public User() {
    }

    public User(String userName, String userLastName, String email, String password) {
        this.userName = userName;
        this.userLastName = userLastName;
        this.email = email;
        this.password = password;
    }

}
