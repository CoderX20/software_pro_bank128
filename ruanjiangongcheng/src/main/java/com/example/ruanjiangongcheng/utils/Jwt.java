package com.example.ruanjiangongcheng.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.lang.reflect.Field;
import java.security.Key;
import java.util.*;

public class Jwt {
//    private static final Key SECRET_KEY = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);

    public static String createToken(Object obj,long expireTimeInMills) throws IllegalAccessException {
        List<String> fieldNames=new ArrayList<>();
        Class<?> clazz=obj.getClass();
        Field[] fields= clazz.getDeclaredFields();
        Map<String,Object> map = new HashMap<>();
        for (Field f:fields) {
            f.setAccessible(true);
            map.put(f.getName(),f.get(obj));
        }
        Map<String,Object> map1 = new HashMap<>();
        map1.put("name","mike");
        map1.put("age",10);
        return Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis()+expireTimeInMills))
                .signWith(SignatureAlgorithm.HS256,"128821")
                .compact();
    }
    public static Claims parseToken(String token){
        return Jwts.parser()
                .setSigningKey("128821")
                .parseClaimsJws(token)
                .getBody();
    }
}
