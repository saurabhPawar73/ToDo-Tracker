package com.capstone.todo.userservice.service;

import com.capstone.todo.userservice.feign.Dto;
import com.capstone.todo.userservice.feign.UserProxy;
import com.capstone.todo.userservice.model.User;
import com.capstone.todo.userservice.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserProxy userProxy;

    @Override
    public User createUser(User user) {
        Dto dto = new Dto(user.getEmailId(), user.getName());
        userProxy.sendDtoToTaskService(dto);
        return userRepo.save(user);}

    @Override
    public void deleteUser(Integer id) {
        userRepo.deleteById(id);}

    @Override
    public User login(String emailId, String password) {
        return userRepo.findByEmailIdAndPassword(emailId, password);
    }
}
