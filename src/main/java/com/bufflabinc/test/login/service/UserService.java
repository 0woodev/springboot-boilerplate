package com.bufflabinc.test.login.service;

import com.bufflabinc.test.login.controller.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
}
