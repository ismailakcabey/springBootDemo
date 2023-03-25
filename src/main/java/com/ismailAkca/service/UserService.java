package com.ismailAkca.service;

import com.ismailAkca.dto.UserDto;
import com.ismailAkca.entity.User;
import com.ismailAkca.util.CustomPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    List<UserDto> getUsers();

    UserDto getUser(Long id);

    UserDto updateUserById(UserDto user, Long id);

    Page<User> pagenationUser(int currentPage, int pageSize);

    Page<User> pagenationUserV1(Pageable pageable);

    Page<User> slice(Pageable pageable);

    CustomPage<UserDto> customPage(Pageable page);

}
