package com.kameleoon.techtask.services;

import com.kameleoon.techtask.model.User;
import com.kameleoon.techtask.model.dto.UserDto;
import com.kameleoon.techtask.repo.UserRepo;
import com.kameleoon.techtask.util.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    private final UserRepo repo;

    @Autowired
    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public List<User> findAll() {
        System.out.println(repo.findAll().toString());
        return repo.findAll();
    }

    public User findById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public User save(User user) {
        user.setDateOfCreation(LocalDateTime.now());
        repo.save(user);
        return user;
    }

    public void delete(int id) {
        repo.delete(findById(id));
    }

    public User updateUser(int id, UserDto user) {
        User userFromDb = findById(id);
        userFromDb.setName(user.getName());
        userFromDb.setEmail(user.getEmail());
        userFromDb.setPassword(user.getPassword());
        repo.save(userFromDb);
        return userFromDb;
    }


}
