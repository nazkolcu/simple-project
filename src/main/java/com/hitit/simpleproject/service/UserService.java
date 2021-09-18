package com.hitit.simpleproject.service;

import com.hitit.simpleproject.entity.User;

import java.util.Optional;

public interface UserService {
    Iterable<User> findAll();

    Optional<User> findByName(String name);

    User create(User user);

    Optional<User> findById(long id);

    void delete(User user);
}
