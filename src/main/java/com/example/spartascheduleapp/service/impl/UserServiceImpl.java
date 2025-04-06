package com.example.spartascheduleapp.service.impl;

import com.example.spartascheduleapp.dto.user.SignupRequestDto;
import com.example.spartascheduleapp.dto.user.SignupResponseDto;
import com.example.spartascheduleapp.dto.user.UpdatePasswordRequestDto;
import com.example.spartascheduleapp.dto.user.UserResponseDto;
import com.example.spartascheduleapp.entity.User;
import com.example.spartascheduleapp.repository.UserRepository;
import com.example.spartascheduleapp.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override // 회원가입
    public SignupResponseDto signup(SignupRequestDto requestDto) {
        User user = new User(requestDto.getUsername(), requestDto.getEmail(), requestDto.getPassword());
        User saveUser = userRepository.save(user);
        return new SignupResponseDto(saveUser.getId(), saveUser.getUsername(), saveUser.getEmail());
    }

    @Override // 회원조회
    public UserResponseDto findById(Long id) {
        User foundUser = userRepository.findByIdOrElseThrow(id); // NPE 방지
        return new UserResponseDto(foundUser.getUsername(), foundUser.getEmail());
    }

    @Transactional //하나의 트랜잭션 안에서 동작하도록 묶어줌
    @Override // 비번변경
    public void updatePassword(Long id, UpdatePasswordRequestDto requestDto) {
        User foundUser = userRepository.findByIdOrElseThrow(id); // NPE 방지

        if (!foundUser.getPassword().equals(requestDto.getOldPassword())) {
            //기존에 저장된 pw랑 현재비번(oldPw) 같은지 확인하는 로직. 만약 같지 않으면 throw함
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }
        foundUser.updatePassword(requestDto.getNewPassword());

    }

    @Override // 회원삭제
    public void delete(Long id) {
        User foundUser = userRepository.findByIdOrElseThrow(id);
        userRepository.delete(foundUser);
    }
}
