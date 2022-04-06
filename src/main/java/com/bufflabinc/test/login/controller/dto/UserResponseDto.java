package com.bufflabinc.test.login.controller.dto;

import com.bufflabinc.test.login.domain.user.User;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class UserResponseDto {

    private Long id;

    private String email;

    private String name;

    private String phone;

    private String profileImg;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.email =user.getEmail();
        this.name = user.getName();
        this.phone = user.getPhone();
        this.profileImg = user.getProfileImg();
    }
}
