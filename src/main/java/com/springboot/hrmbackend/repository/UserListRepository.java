package com.springboot.hrmbackend.repository;

import com.springboot.hrmbackend.entity.UserList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserListRepository extends JpaRepository<UserList,Integer> {
}
