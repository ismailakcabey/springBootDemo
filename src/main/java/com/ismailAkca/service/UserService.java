package com.ismailAkca.service;

import com.ismailAkca.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    List<User> getUsers();

    User getUser(Long id);
}
