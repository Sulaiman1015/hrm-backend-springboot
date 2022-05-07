package com.springboot.hrmbackend.jwt;

import com.springboot.hrmbackend.entity.User;
import io.jsonwebtoken.*;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {
    private static String token;

    public static String  getToken(User user) {
        //Jwts.builder()  generate token
        //Jwts.parser()   verify token
        token =  Jwts.builder()
                .setId(user.getId()+"")
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())//login time
                .setIssuer("sans")
                .setExpiration(new Date(new Date().getTime()+86400000))//set expire time 48H from login time
                .signWith(SignatureAlgorithm.HS256, "mytoken").compact();
        //first three is for payload, last one is for header
        return  token;
    }

    /**
     * 验证JWT
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        User user = (User) userDetails;
        String username = getUsernameFromToken( token );
        return (username.equals( user.getUsername() ) && !isTokenExpired( token ));
    }
    /**
     * 获取token是否过期
     */
    public Boolean isTokenExpired(String token) {
        Date expiration = getExpirationDateFromToken( token );
        return expiration.before( new Date() );
    }
    /**
     * 根据token获取username
     */
    public String getUsernameFromToken(String token) {
        return getClaimsFromToken( token ).getSubject();
    }
    /**
     * 获取token的过期时间
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimsFromToken( token ).getExpiration();
    }

    /**
     * 解析JWT
     */
    private Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey( "mytoken" )
                .parseClaimsJws( token )
                .getBody();
    }



}
