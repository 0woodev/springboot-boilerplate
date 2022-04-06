package com.bufflabinc.test.login.domain.user;


import com.bufflabinc.test.login.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String oAuth2Id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column
    private String profileImg;

    private Role role;

    @Builder
    public User(Long id, String email, String name, String phone, String profileImg) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.profileImg = profileImg;
    }
}
