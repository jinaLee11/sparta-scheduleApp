package com.example.spartascheduleapp.dto.schedule;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// 일정의 제목, 내용 수정용

@Getter
@RequiredArgsConstructor
public class ScheduleRequestDto {

    private final String title;
    private final String content;

}
