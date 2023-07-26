package com.capstone.todo.userservice.service;

import com.capstone.todo.userservice.model.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

public interface UserService {

    public User createUser(User user);

    public User login(String emailId, String password);
    void deleteUser(Integer id);

}
