/*
 * UserRepository.java
 *
 * Copyright (C) 2017 Stephen Legge, Tim McCrabb and Andy Redfearn
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

package com.riskysolid.lavishduck.repository;

import org.springframework.data.repository.CrudRepository;

import com.riskysolid.lavishduck.repository.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
