package com.capstone.todo.userservice.controller;

import com.capstone.todo.userservice.model.User;
import com.capstone.todo.userservice.service.TokenGeneration;
import com.capstone.todo.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/todo")
@RestController
public class Controller {

    @Autowired
    private UserService service;

    @Autowired
    private TokenGeneration tokenGeneration;


    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        return new ResponseEntity<>(service.createUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/remove-user/{id}")
    public void removeUser(@PathVariable(name = "id")Integer id){
         service.deleteUser(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
       User user1=service.login(user.getEmailId(), user.getPassword());

       if (user1!=null){
           return new ResponseEntity<>(tokenGeneration.generateToken(user), HttpStatus.OK);
       }
       else
           return new ResponseEntity<>("No User Found", HttpStatus.NOT_FOUND);
    }

}
