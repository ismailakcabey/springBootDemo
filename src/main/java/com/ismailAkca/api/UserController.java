package com.ismailAkca.api;

import com.ismailAkca.dto.UserDto;
import com.ismailAkca.entity.User;
import com.ismailAkca.service.UserService;
import com.ismailAkca.util.CustomPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        UserDto resultUser = userService.createUser(user);
        return ResponseEntity.ok(resultUser);
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
        UserDto user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<UserDto> updateUserById(@RequestBody UserDto user, @PathVariable("id") Long id){
        UserDto resultUser =  userService.updateUserById(user,id);
        return ResponseEntity.ok(resultUser);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<User>> paginationUser(@RequestParam int currentPage, @RequestParam int pageSize){
        Page<User> users = userService.pagenationUser(currentPage,pageSize);
        return  ResponseEntity.ok(users);
    }

    @GetMapping("/pagination/v1")
    public ResponseEntity<Page<User>> paginationUserV1(Pageable pageable){
        Page<User> users = userService.pagenationUserV1(pageable);
        return  ResponseEntity.ok(users);
    }

    @GetMapping("/pagination/v2")
    public ResponseEntity<Slice<User>> slice(Pageable pageable){
        Page<User> users = userService.slice(pageable);
        return  ResponseEntity.ok(users);
    }

    @GetMapping("/customPage")
    public ResponseEntity<CustomPage<UserDto>> customPage(Pageable pageable){
        CustomPage<UserDto> users = userService.customPage(pageable);
        return  ResponseEntity.ok(users);
    }

}
