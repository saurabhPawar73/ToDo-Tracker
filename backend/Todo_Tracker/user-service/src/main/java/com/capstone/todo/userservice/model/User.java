package com.capstone.todo.userservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    private String emailId;
    private String name;
    private String password;

    public User(String name, String password, String emailId) {
        this.emailId = emailId;
        this.name = name;
        this.password = password;
    }
}
