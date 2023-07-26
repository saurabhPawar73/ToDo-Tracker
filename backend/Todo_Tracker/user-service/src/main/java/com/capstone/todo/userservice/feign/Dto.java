package com.capstone.todo.userservice.feign;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dto {
    private String emailId;
    private String name;
}
