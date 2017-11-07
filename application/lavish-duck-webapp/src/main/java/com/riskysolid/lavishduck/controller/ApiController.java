/*
 * ApiController.java
 *
 * Copyright (C) 2017 Stephen Legge, Tim McCrabb and Andy Redfearn
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

package com.riskysolid.lavishduck.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/api")
public class ApiController {

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "role/{role}", method = RequestMethod.GET)
    public Boolean login(@PathVariable final String role,
            final HttpServletRequest request) throws ServletException {
        final Claims claims = (Claims) request.getAttribute("claims");

        return ((List<String>) claims.get("roles")).contains(role);
    }
}
