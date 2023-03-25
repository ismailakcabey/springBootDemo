package com.ismailAkca.service.impl;

import com.ismailAkca.advice.UserNotFound;
import com.ismailAkca.dto.UserDto;
import com.ismailAkca.entity.User;
import com.ismailAkca.repository.UserRepository;
import com.ismailAkca.service.UserService;
import com.ismailAkca.util.CustomPage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = modelMapper.map(userDto,User.class);
        user.setCreatedDate(new Date());
        user.setCreatedBy("Admin");
        return modelMapper.map(userRepository.save(user),UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
        return  userDtos;
    }

    @Override
    public UserDto getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) return modelMapper.map(user.get(),UserDto.class);
        throw new UserNotFound("user is not defined");
    }


    @Override
    public UserDto updateUserById(UserDto user, Long id) {
        Optional<User> updateUser = userRepository.findById(id);
        if(!(updateUser.isPresent())) return null;
        if(user.getFirstName() != null){
            updateUser.get().setFirstName(user.getFirstName());
        }
        if(user.getLastName() != null){
            updateUser.get().setLastName(user.getLastName());
        }
        updateUser.get().setUpdatedAt(new Date());
        updateUser.get().setUpdatedBy("admin");
        return modelMapper.map(userRepository.save(updateUser.get()),UserDto.class);
    }

    @Override
    public Page<User> pagenationUser(int currentPage, int pageSize) {
        Pageable pageable = PageRequest.of(currentPage,pageSize);
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> pagenationUserV1(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> slice(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public CustomPage<UserDto> customPage(Pageable page) {
        Page<User> users = userRepository.findAll(page);
        UserDto[] usersDto = modelMapper.map(users.getContent(),UserDto[].class);
        return new CustomPage<UserDto>(users, Arrays.asList(usersDto));
    }


}
