package com.bufflabinc.test.login.service;

import com.bufflabinc.test.login.controller.dto.UserRequestDto;
import com.bufflabinc.test.login.controller.dto.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserResponseDto> getAllUsers();

    Long addUser(UserRequestDto user);
}
