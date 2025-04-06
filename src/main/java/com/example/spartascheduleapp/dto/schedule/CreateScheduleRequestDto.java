package com.example.spartascheduleapp.dto.schedule;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 게터
@RequiredArgsConstructor // final 필드의 생성자
public class CreateScheduleRequestDto {

    private final String writer;
    private final String title;
    private final String content;


}
