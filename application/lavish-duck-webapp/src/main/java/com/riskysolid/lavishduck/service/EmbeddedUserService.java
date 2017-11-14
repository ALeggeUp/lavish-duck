/*
 * EmbeddedUserService.java
 *
 * Copyright (C) 2017 Stephen Legge, Tim McCrabb and Andy Redfearn
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

package com.riskysolid.lavishduck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riskysolid.lavishduck.repository.UserRepository;
import com.riskysolid.lavishduck.repository.entity.User;

@Service
public class EmbeddedUserService implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public EmbeddedUserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(final User user) {
        userRepository.save(user);
    }

    @Override
    public User getById(final String key) {
        return userRepository.findOne(key);
    }

    @Override
    public boolean containsKey(final String key) {
        return userRepository.exists(key);
    }
}
