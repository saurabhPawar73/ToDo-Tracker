package com.todo.taskservice.services;

import com.todo.taskservice.model.Task;
import com.todo.taskservice.model.User;
import com.todo.taskservice.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            if (tasks.contains(task)){
                List<Task> tasks1=new ArrayList<>();

            }
            tasks.add(task);
        }else {
        List<Task> tasks=new ArrayList<>();
        tasks.add(task);
        user.setTasks(tasks);}
        return userRepo.save(user);
    }


    public User deleteTask(Task task, String eid){
        User user=userRepo.findById(eid).get();
        user.getTasks().remove(task);
        userRepo.save(user);
        return user;
    }

    public User getLoggedInUser(String eid){
        return userRepo.findById(eid).get();
    }

    public int getIndexOfTask(Task task, String eid){
        List<Task> tasks=userRepo.findById(eid).get().getTasks();
        int index=tasks.indexOf(task);
            return index;
    }

    public User updateTask(Task task, String eid, int index){

        User user=userRepo.findById(eid).get();
        List<Task> tasks=user.getTasks();
        tasks.remove(index);
        tasks.add(task);
        return userRepo.save(user);
    }

}
