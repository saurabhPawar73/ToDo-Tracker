package com.capstone.todo.userservice.feign;


import org.apache.coyote.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "taskservice", url = "localhost:8888")
public interface UserProxy {

    @PostMapping("/taskservice/addUser")
    public abstract ResponseEntity<?> sendDtoToTaskService(@RequestBody Dto dto);
}
