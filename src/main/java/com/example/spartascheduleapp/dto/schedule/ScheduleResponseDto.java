package com.example.spartascheduleapp.dto.schedule;

import com.example.spartascheduleapp.entity.Schedule;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ScheduleResponseDto {

    private final Long id;
    private final String writer;
    private final String title;
    private final String content;

    // 전체조회 때 Schedule -> ScheduleResponseDto 로 반환해주는 메서드 필요해서 만들어 줌
    public static ScheduleResponseDto toDto(Schedule schedule){
        return new ScheduleResponseDto(schedule.getId(),schedule.getWriter(),schedule.getTitle(),schedule.getContent());
    }

}
