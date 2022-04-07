package com.bufflabinc.test.login.config.auth.dto;

import com.bufflabinc.test.login.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private final String name;
    private final String email;
    private final String profileImg;


    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.profileImg = user.getProfileImg();
    }
}
