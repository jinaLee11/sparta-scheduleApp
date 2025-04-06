package com.example.spartascheduleapp.dto.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// 회원가입 요청

@Getter
@RequiredArgsConstructor
public class SignupRequestDto {

    private final String username;
    private final String email;
    private final String password;

}
