package com.example.miniprojectee.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.miniprojectee.enums.Gender;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private int age;
    private String avatar;
    private Gender gender;
    private String phoneNumber;
}
