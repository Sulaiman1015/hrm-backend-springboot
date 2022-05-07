package com.springboot.hrmbackend.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.hrmbackend.entity.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {
    JwtTokenUtil token = new JwtTokenUtil();
    private AuthenticationManager authenticationManager;

    /*public JwtLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }*/

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res){
        try {
            User user =new ObjectMapper().readValue(req.getInputStream(), User.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPassword(),
                            new ArrayList<>())
            );
        } catch (Exception e) {
            try {

                res.setContentType("application/json;charset=utf-8");
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                PrintWriter out = res.getWriter();
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("code", HttpServletResponse.SC_UNAUTHORIZED);
                map.put("msg","Username or Password is wrong");
                out.write(new ObjectMapper().writeValueAsString(map));
                out.flush();
                out.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth){

        res.addHeader("Authorization", "Bearer " + token);
        try {
            res.setContentType("application/json;charset=utf-8");
            res.setStatus(HttpServletResponse.SC_OK);
            PrintWriter out = res.getWriter();
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("code",HttpServletResponse.SC_OK);
            map.put("msg","login success！");
            out.write(new ObjectMapper().writeValueAsString(map));
            out.flush();
            out.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
