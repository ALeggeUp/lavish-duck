/*
 * UserController.java
 *
 * Copyright (C) 2017 Stephen Legge, Tim McCrabb and Andy Redfearn
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

package com.riskysolid.lavishduck.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.riskysolid.lavishduck.controller.exception.InvalidLoginException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Map<String, List<String>> userDb = new HashMap<>();

    public UserController() {
        userDb.put("tom", Arrays.asList("user"));
        userDb.put("sally", Arrays.asList("user", "admin"));
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public LoginResponse login(@RequestBody final UserLogin login) throws InvalidLoginException {

        if (login == null || login.name == null || !userDb.containsKey(login.name)) {
            throw new InvalidLoginException();
        }

        return new LoginResponse(Jwts.builder().setSubject(login.name)
            .claim("roles", userDb.get(login.name)).setIssuedAt(new Date())
            .signWith(SignatureAlgorithm.HS256, "secretkey").compact());
    }

    @SuppressWarnings("unused")
    private static class UserLogin {
        public String name;
        public String password;
    }

    @SuppressWarnings("unused")
    private static class LoginResponse {
        public String token;

        public LoginResponse(final String token) {
            this.token = token;
        }
    }
}
