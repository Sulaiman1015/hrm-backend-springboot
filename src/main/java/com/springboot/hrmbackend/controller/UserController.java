package com.springboot.hrmbackend.controller;

import com.springboot.hrmbackend.entity.User;
import com.springboot.hrmbackend.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    /*@Autowired
    private UserListService userListService;

    @GetMapping("/userlist")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userListService.getUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users").toUriString());
        return ResponseEntity.created(uri).body(userListService.saveUser(user));
    }*/


}
