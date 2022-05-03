package com.springboot.hrmbackend.service;

import com.springboot.hrmbackend.entity.UserList;
import com.springboot.hrmbackend.repository.UserListRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserListService {
    @Autowired
    private UserListRepository userListRepository;

    public UserList getUser(Integer id){
        return userListRepository.findById(id).get();
    }
}
