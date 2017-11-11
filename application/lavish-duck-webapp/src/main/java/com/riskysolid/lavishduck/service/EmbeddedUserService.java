/*
 * EmbeddedUserService.java
 *
 * Copyright (C) 2017 Stephen Legge, Tim McCrabb and Andy Redfearn
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

package com.riskysolid.lavishduck.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class EmbeddedUserService implements UserService {

    private final Map<String, List<String>> userDb = new HashMap<>();

    public EmbeddedUserService() {
        userDb.put("tom", Arrays.asList("user"));
        userDb.put("sally", Arrays.asList("user", "admin"));
    }

    @Override
    public void put(final String key, final List<String> list) {
        userDb.put(key, list);
    }

    @Override
    public List<String> get(final String key) {
        return userDb.get(key);
    }

    @Override
    public boolean containsKey(final String key) {
        return userDb.containsKey(key);
    }
}
