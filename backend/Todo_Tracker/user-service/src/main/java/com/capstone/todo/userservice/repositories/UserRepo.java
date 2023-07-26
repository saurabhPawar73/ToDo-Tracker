package com.capstone.todo.userservice.repositories;

import com.capstone.todo.userservice.model.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

public User findByEmailIdAndPassword(String eid, String password);
}
