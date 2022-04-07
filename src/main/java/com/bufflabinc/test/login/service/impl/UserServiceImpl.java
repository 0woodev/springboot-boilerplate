package com.bufflabinc.test.login.service.impl;

import com.bufflabinc.test.login.controller.dto.UserResponseDto;
import com.bufflabinc.test.login.domain.user.UserRepository;
import com.bufflabinc.test.login.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }
}
