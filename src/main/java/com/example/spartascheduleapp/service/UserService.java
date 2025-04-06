package com.example.spartascheduleapp.service;

import com.example.spartascheduleapp.dto.user.SignupRequestDto;
import com.example.spartascheduleapp.dto.user.SignupResponseDto;
import com.example.spartascheduleapp.dto.user.UpdatePasswordRequestDto;
import com.example.spartascheduleapp.dto.user.UserResponseDto;

public interface UserService {

    SignupResponseDto signup(SignupRequestDto requestDto);

    UserResponseDto findById(Long id);

    void updatePassword(Long id, UpdatePasswordRequestDto requestDto );

    void delete(Long id);
}
