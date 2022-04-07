package com.bufflabinc.test.login.controller.dto;

import com.bufflabinc.test.login.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private final Long id;

    private final String email;

    private final String name;

//    private final String phone;

    private final String profileImg;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.email =user.getEmail();
        this.name = user.getName();
//        this.phone = user.getPhone();
        this.profileImg = user.getProfileImg();
    }
}
