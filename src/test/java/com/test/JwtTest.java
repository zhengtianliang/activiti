package com.test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.util.Date;

/**
 * @author: ZhengTianLiang
 * @date: 2020/11/2  16:14
 * @desc: 測試jwt的类
 */
public class JwtTest {

    /**
     * @author: ZhengTianLiang
     * @date: 2020/11/2  16:14
     * @desc: 測試生成jwt的方法
     */
    @Test
    public void generateJwtTest() {
        JwtBuilder jwtBuilder = Jwts.builder().setId("123") // 可以setid，也可以不setid，约定俗成的是set
                .setSubject("良哥帅") // 可以setSubject，也可以不setSubject，约定俗成的是set
                .setIssuedAt(new Date()) // 设置签发日期
                .signWith(SignatureAlgorithm.HS256, "zhengtianliang") // 设置加密算法和盐
                .claim("key", "value")  // 可以自定义key
                .claim("key2", "nihao"); // 自定义key
        String token = jwtBuilder.compact(); // 生成token

        System.out.println(token);
    }

    /**
     * @author: ZhengTianLiang
     * @date: 2020/11/2  16:24
     * @desc: 解析jwt的方法
     */
    @Test
    public void parserJwtTest() {
        // 将上个方法中生成的token 拿到
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMjMiLCJzdWIiOiLoia_lk6XluIUiLCJpYXQiOjE2MDQzMDc4NjIsImtleSI6InZhbHVlIiwia2V5MiI6Im5paGFvIn0.9zb0rZWHhe4KB-kxdOarCd1arIhiJQYNLOX7SRsBX4w";
        Claims claims = Jwts.parser().setSigningKey("zhengtianliang").parseClaimsJws(token).getBody();

        // 输出一下信息
        System.out.println(claims.getId()); // 123
        System.out.println(claims.getSubject()); // 良哥帅
        System.out.println(claims.getIssuedAt()); // Mon Nov 02 16:19:58 CST 2020
        System.out.println(claims.get("key"));
        System.out.println(claims.get("key2"));
    }


}
