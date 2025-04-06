package com.example.spartascheduleapp.dto.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// 회원가입 응답

@Getter
@RequiredArgsConstructor
public class SignupResponseDto {

    private final Long id;
    private final String username;
    private final String email;

}
