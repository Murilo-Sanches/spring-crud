package com.msspring.ms.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msspring.ms.model.User;
import com.msspring.ms.service.UserService;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.Valid;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@Valid @NonNull @RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping(path = "/{id}")
    public User getPersonById(@PathVariable("id") UUID id) {
        return userService.getPersonById(id).orElse(null);
    }

    @PatchMapping(path = "/{id}")
    public void updateUserById(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUseById(@PathVariable("id") UUID id) {
        userService.deleteUser(id);
    }
}
