package com.springboot.hrmbackend.controller;

import com.springboot.hrmbackend.entity.User;
import com.springboot.hrmbackend.jwt.JwtTokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {


    /*@PostMapping("/{username}/{rolename}")
    public Object validLogin(@RequestParam(value = "username") @PathVariable String username,
                             @RequestParam(value = "password") String password,
                             @RequestParam(value = "rolename") @PathVariable String rolename
    ) {
        Map<String, Object> map = new HashMap<>();
        //if (username != null || password!= null || rolename != null)
        User getUser = loginService.login(username, password);

        if(getUser!=null){
            String token = JwtTokenUtil.getToken(getUser);
            map.put("user",getUser);
            map.put("token",token);
            map.put("msg", "login success");
            map.put("code", 200);
        }else{
            map.put("msg", "Username or Password is not correct");
            map.put("code", 100);
        }

        return map;
    }*/

}
