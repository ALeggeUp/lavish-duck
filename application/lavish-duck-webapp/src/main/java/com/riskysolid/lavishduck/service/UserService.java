/*
 * UserService.java
 *
 * Copyright (C) 2017 Stephen Legge, Tim McCrabb and Andy Redfearn
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

package com.riskysolid.lavishduck.service;

import java.util.List;

public interface UserService {

    void put(String key, List<String> list);

    List<String> get(String key);

    boolean containsKey(String key);
}
