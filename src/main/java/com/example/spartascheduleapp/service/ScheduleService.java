package com.example.spartascheduleapp.service;

import com.example.spartascheduleapp.dto.schedule.CreateScheduleRequestDto;
import com.example.spartascheduleapp.dto.schedule.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto save(CreateScheduleRequestDto requestDto);

    List<ScheduleResponseDto> findAll();

}
