package com.example.spartascheduleapp.service;

import com.example.spartascheduleapp.dto.schedule.CreateScheduleRequestDto;
import com.example.spartascheduleapp.dto.schedule.ScheduleRequestDto;
import com.example.spartascheduleapp.dto.schedule.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto save(CreateScheduleRequestDto requestDto);

    List<ScheduleResponseDto> findAll();

    ScheduleResponseDto findById(Long id);

    void delete(Long id);

    ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto);

}
