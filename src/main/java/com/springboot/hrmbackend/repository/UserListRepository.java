package com.springboot.hrmbackend.repository;

import com.springboot.hrmbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserListRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username,String password);
}
