package com.bufflabinc.test.login.controller;

import com.bufflabinc.test.login.controller.dto.UserRequestDto;
import com.bufflabinc.test.login.controller.dto.UserResponseDto;
import com.bufflabinc.test.login.domain.user.User;
import com.bufflabinc.test.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("")
    public ResponseEntity<Long> addUser(@RequestParam UserRequestDto requestDto) {
        return ResponseEntity.ok(userService.addUser(requestDto));
    }
}
