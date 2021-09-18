package com.hitit.simpleproject.service;

import com.hitit.simpleproject.entity.User;
import com.hitit.simpleproject.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
