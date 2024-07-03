package com.pushkar.SpringBoot_REST.repository;

import com.pushkar.SpringBoot_REST.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
