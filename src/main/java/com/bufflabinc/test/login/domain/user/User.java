package com.bufflabinc.test.login.domain.user;


import com.bufflabinc.test.login.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(unique = true, nullable = false)
//    private String oAuth2Id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

//    @Column(nullable = false)
//    private String phone;

    @Column
    private String profileImg;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(Long id, String email, String name, /*String phone,*/ String profileImg, Role role) {
        this.id = id;
        this.email = email;
        this.name = name;
//        this.phone = phone;
        this.profileImg = profileImg;
        this.role = role;
    }

    public User update(String name, String profileImg) {
        this.name = name;
        this.profileImg = profileImg;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

}
