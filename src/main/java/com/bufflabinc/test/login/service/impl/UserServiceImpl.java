package com.bufflabinc.test.login.service.impl;

import com.bufflabinc.test.login.controller.dto.UserRequestDto;
import com.bufflabinc.test.login.controller.dto.UserResponseDto;
import com.bufflabinc.test.login.domain.user.UserRepository;
import com.bufflabinc.test.login.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public Long addUser(UserRequestDto user) {
//        return userRepository.save(user);
        return 1L;
    }


}
