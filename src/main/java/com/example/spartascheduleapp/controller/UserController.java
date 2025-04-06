package com.example.spartascheduleapp.controller;

import com.example.spartascheduleapp.dto.user.SignupRequestDto;
import com.example.spartascheduleapp.dto.user.SignupResponseDto;
import com.example.spartascheduleapp.dto.user.UpdatePasswordRequestDto;
import com.example.spartascheduleapp.dto.user.UserResponseDto;
import com.example.spartascheduleapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup") // 회원가입 C
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto requestDto){
        SignupResponseDto signupResponseDto = userService.signup(requestDto);
        return new ResponseEntity<>(signupResponseDto, HttpStatus.CREATED); //201
    }

    @GetMapping("/{id}") // 특정 회원 조회 R
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id){
        UserResponseDto userResponseDto = userService.findById(id);
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

    @PatchMapping("/{id}") // 비밀번호 수정 U
    public ResponseEntity<Void> updatePassword(
            @PathVariable Long id,
            @RequestBody UpdatePasswordRequestDto requestDto
    ) {
        userService.updatePassword(id, requestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}") // 회원 삭제 D
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
