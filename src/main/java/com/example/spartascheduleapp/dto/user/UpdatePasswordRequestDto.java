package com.example.spartascheduleapp.dto.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// 비밀번호 변경 -> 구비번과 변경할비번 입력받고, 구비번 = DB에 등록된 비번이면 뉴비번으로 update

@Getter
@RequiredArgsConstructor
public class UpdatePasswordRequestDto {
    private final String oldPassword;
    private final String newPassword;
}
