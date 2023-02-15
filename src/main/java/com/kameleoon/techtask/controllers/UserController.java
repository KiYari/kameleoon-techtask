package com.kameleoon.techtask.controllers;

import com.kameleoon.techtask.model.User;
import com.kameleoon.techtask.model.dto.UserDto;
import com.kameleoon.techtask.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(originPatterns = "*", maxAge = 3600)
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/users")
    public List<User> listAll() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.findById(id);
    }

    @PostMapping(value = "/users", consumes = "application/json")
    public User createNewUser(@RequestBody UserDto user){
        return userService.save(mapToUser(user));
    }

    @DeleteMapping("/user/{id}")
    public HttpStatus deleteUser(@PathVariable int id) {
        userService.delete(id);
        return HttpStatus.OK;
    }

    @PatchMapping(value = "user/{id}", consumes = "application/json")
    public User updateUserInfo(@PathVariable int id, @RequestBody UserDto user) {
        return userService.updateUser(id, user);
    }

    private User mapToUser(UserDto dto) {
        return modelMapper.map(dto, User.class);
    }
}
