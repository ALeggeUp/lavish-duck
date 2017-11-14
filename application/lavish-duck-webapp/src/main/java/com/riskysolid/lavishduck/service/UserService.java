/*
 * UserService.java
 *
 * Copyright (C) 2017 Stephen Legge, Tim McCrabb and Andy Redfearn
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

package com.riskysolid.lavishduck.service;

import com.riskysolid.lavishduck.repository.entity.User;

public interface UserService {

    void save(User user);

    User getById(String key);

    boolean containsKey(String key);

    String encrypt(String raw);

    boolean matches(String raw, String encoded);

    long count();
}
