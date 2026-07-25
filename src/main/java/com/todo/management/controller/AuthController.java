package com.todo.management.controller;


import com.todo.management.entity.User;
import com.todo.management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    public User login(
            @RequestBody User user
    ){

        return userService.login(
                user.getEmail(),
                user.getPassword()
        );

    }

}