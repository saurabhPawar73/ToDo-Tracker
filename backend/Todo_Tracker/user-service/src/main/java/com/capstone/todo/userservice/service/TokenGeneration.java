package com.capstone.todo.userservice.service;


import com.capstone.todo.userservice.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenGeneration {

    public Map<String, String> generateToken(User user){

        Map<String, String> token=new HashMap<>();

        Map<String, Object> tokenData=new HashMap<>();
        tokenData.put("emailId", user.getEmailId());
        tokenData.put("name", user.getName());
        tokenData.put("password", user.getPassword());
        String tokenbuilder= Jwts.builder()
                .setClaims(tokenData)
                .setIssuedAt(new Date())
                .setIssuer("todo_user")
                .signWith(SignatureAlgorithm.HS512, "todo-key")
                .compact();

        token.put("token", tokenbuilder);
        token.put("message", "login successfull, token generated");
        token.put("emailId", user.getEmailId());
        token.put("name", user.getName());

        return token;
    }

    }
