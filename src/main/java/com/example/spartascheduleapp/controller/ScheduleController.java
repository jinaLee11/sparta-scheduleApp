package com.example.spartascheduleapp.controller;

import com.example.spartascheduleapp.dto.schedule.CreateScheduleRequestDto;
import com.example.spartascheduleapp.dto.schedule.ScheduleRequestDto;
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
    public ResponseEntity<List<ScheduleResponseDto>> findAll(){
        List<ScheduleResponseDto> scheduleResponseDto = scheduleService.findAll();
        return new ResponseEntity<>(scheduleResponseDto,HttpStatus.OK); // 성공 200
    }

    @GetMapping("/{id}") // 단일 일정 조회 R
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id){
        ScheduleResponseDto scheduleResponseDto = scheduleService.findById(id);
        return new ResponseEntity<>(scheduleResponseDto,HttpStatus.OK); // 성공 200
    }

    @PatchMapping("/{id}") // 일정 수정 U (작성자 수정 불가, 제목&내용만 변경 가능)
    public ResponseEntity<ScheduleResponseDto> updateSchedule(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto scheduleRequestDto
            ) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.updateSchedule(id,scheduleRequestDto);
        return new ResponseEntity<>(scheduleResponseDto,HttpStatus.OK); // 성공 200
    }

    @DeleteMapping("/{id}") // 일정 삭제 D
    public ResponseEntity<Void> delete(@PathVariable Long id){
        scheduleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK); // 성공 200
    }



}
