package com.bufflabinc.test.login.domain.user;


import com.bufflabinc.test.login.domain.BaseTimeEntity;
import lombok.Builder;

import javax.persistence.*;

@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column
    private String profileImg;

//    private Role role;

    @Builder
    public User(Long id, String name, String phone, String profileImg) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.profileImg = profileImg;
    }
}
