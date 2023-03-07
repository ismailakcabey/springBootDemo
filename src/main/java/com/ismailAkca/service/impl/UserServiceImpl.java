package com.ismailAkca.service.impl;

import com.ismailAkca.entity.User;
import com.ismailAkca.repository.UserRepository;
import com.ismailAkca.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        user.setCreatedDate(new Date());
        user.setCreatedBy("Admin");
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) return user.get();
        else return null;
    }

}
