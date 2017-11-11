/*
 * UserController.java
 *
 * Copyright (C) 2017 Stephen Legge, Tim McCrabb and Andy Redfearn
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

package com.riskysolid.lavishduck.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.riskysolid.lavishduck.controller.exception.InvalidLoginException;
import com.riskysolid.lavishduck.model.LoginResponse;
import com.riskysolid.lavishduck.model.UserLogin;
import com.riskysolid.lavishduck.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public LoginResponse login(@RequestBody final UserLogin login) throws InvalidLoginException {

        if (login == null || login.getName() == null || !userService.containsKey(login.getName())) {
            throw new InvalidLoginException();
        }

        return new LoginResponse(Jwts.builder().setSubject(login.getName())
            .claim("roles", userService.get(login.getName()))
            .setIssuedAt(new Date())
            .signWith(SignatureAlgorithm.HS256, "secretkey")
            .compact());
    }
}
