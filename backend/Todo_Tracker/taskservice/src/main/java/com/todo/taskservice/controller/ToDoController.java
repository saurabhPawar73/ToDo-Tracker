package com.todo.taskservice.controller;

import com.todo.taskservice.model.Task;
import com.todo.taskservice.model.User;
import com.todo.taskservice.services.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/taskservice")
public class ToDoController {

    @Autowired
    private TaskService userService;

    @PostMapping("/addUser")
        public ResponseEntity<?> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/addTask")
    public ResponseEntity<?> addTask(HttpServletRequest httpServletRequest, @RequestBody Task task){
        String userEmailId =(String)httpServletRequest.getAttribute("user-emailId");
        return new ResponseEntity<>(userService.addtasktoUser(task, userEmailId), HttpStatus.OK);
    }

    @GetMapping("/get-user")
    public ResponseEntity<?> getUserWithTasks(HttpServletRequest httpServletRequest){
        String emailId=(String)httpServletRequest.getAttribute("user-emailId");
        return new ResponseEntity<>(userService.getLoggedInUser(emailId), HttpStatus.OK);
    }

    @PostMapping("/delete-task")
    public ResponseEntity<?> deleteTask(HttpServletRequest httpServletRequest, @RequestBody Task task){
        String emailId=(String)httpServletRequest.getAttribute("user-emailId");
        return new ResponseEntity<>(userService.deleteTask(task, emailId), HttpStatus.OK);
    }

    @PostMapping("/get-index")
    public int getIndexOfTask(HttpServletRequest httpServletRequest, @RequestBody Task task){
    String emailId=(String)httpServletRequest.getAttribute("user-emailId");
        return userService.getIndexOfTask(task, emailId);
    }
    @PostMapping("/update-task/{index}")
    public ResponseEntity<?> updateTask(HttpServletRequest httpServletRequest,@RequestBody Task task,@PathVariable(name = "index")int index){
        String emailId=(String)httpServletRequest.getAttribute("user-emailId");
        return new ResponseEntity<>(userService.updateTask(task, emailId, index), HttpStatus.OK);
    }
}
