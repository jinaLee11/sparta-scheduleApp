package com.example.spartascheduleapp.controller;

import com.example.spartascheduleapp.dto.schedule.CreateScheduleRequestDto;
import com.example.spartascheduleapp.dto.schedule.ScheduleResponseDto;
import com.example.spartascheduleapp.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // controller로 쓰겠다 !!
@RequestMapping("/schedules") // 엄마 url
@RequiredArgsConstructor // 생성자
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping // 일정 생성 C
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto){
        ScheduleResponseDto responseDto = scheduleService.save(requestDto);
        return new ResponseEntity<>(responseDto,HttpStatus.CREATED); // 성공 201
    }

    @GetMapping // 전체 일정 조회 R
    public ResponseEntity<ScheduleResponseDto> findAll(){
        List<ScheduleResponseDto> scheduleResponseDto = scheduleService.findAll();
        return new ResponseEntity<>(HttpStatus.OK); // 성공 200
    }





}
