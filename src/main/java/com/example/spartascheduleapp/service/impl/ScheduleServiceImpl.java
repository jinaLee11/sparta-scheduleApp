package com.example.spartascheduleapp.service.impl;

import com.example.spartascheduleapp.dto.schedule.CreateScheduleRequestDto;
import com.example.spartascheduleapp.dto.schedule.ScheduleResponseDto;
import com.example.spartascheduleapp.entity.Schedule;
import com.example.spartascheduleapp.repository.ScheduleRepository;
import com.example.spartascheduleapp.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override // 일정 생성
    public ScheduleResponseDto save(CreateScheduleRequestDto requestDto) {

        Schedule schedule = new Schedule(requestDto.getWriter(), requestDto.getTitle(), requestDto.getContent());

        Schedule saved = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(saved.getId(), saved.getWriter(), saved.getTitle(), saved.getContents());
    }

    @Override // 전체 조회
    public List<ScheduleResponseDto> findAll() {

        return scheduleRepository.findAll().stream()
                .map(ScheduleResponseDto::toDto)
                .toList();

        // 위 코드랑 아래 코드랑 결과적으로 동일함 !!
        //        List<Schedule> scheduleList = scheduleRepository.findAll();
        //        List<ScheduleResponseDto> responseList = new ArrayList<>();
        //        for (Schedule s : scheduleList) {
        //            responseList.add(ScheduleResponseDto.toDto(s));
        //        }
        //        return responseList;
    }






}
