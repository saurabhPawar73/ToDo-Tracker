package com.todo.taskservice.services;

import com.todo.taskservice.model.Task;
import com.todo.taskservice.model.User;
import com.todo.taskservice.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private UserRepo userRepo;

    public User addUser(User user){
        return userRepo.save(user);
    }
    public User addtasktoUser(Task task, String emailId){
        User user=userRepo.findById(emailId).get();
        if (user.getTasks()!=null)
        {
            List<Task> tasks=user.getTasks();
            tasks.add(task);
        }else {
        List<Task> tasks=new ArrayList<>();
        tasks.add(task);
        user.setTasks(tasks);}
        return userRepo.save(user);
    }

    public User getLoggedInUser(String eid){
        return userRepo.findById(eid).get();
    }

}
