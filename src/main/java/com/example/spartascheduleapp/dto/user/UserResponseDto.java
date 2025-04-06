package com.example.spartascheduleapp.dto.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// 특정회원 조회 응답

@Getter
@RequiredArgsConstructor
public class UserResponseDto {

    private final String username;
    private final String email;

}
