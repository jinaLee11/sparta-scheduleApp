package com.example.spartascheduleapp.service.impl;

import com.example.spartascheduleapp.dto.schedule.CreateScheduleRequestDto;
import com.example.spartascheduleapp.dto.schedule.ScheduleRequestDto;
import com.example.spartascheduleapp.dto.schedule.ScheduleResponseDto;
import com.example.spartascheduleapp.entity.Schedule;
import com.example.spartascheduleapp.repository.ScheduleRepository;
import com.example.spartascheduleapp.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Override // 일정 생성
    public ScheduleResponseDto save(CreateScheduleRequestDto requestDto) {

        Schedule schedule = new Schedule(requestDto.getWriter(), requestDto.getTitle(), requestDto.getContent());

        Schedule saved = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(saved.getId(), saved.getWriter(), saved.getTitle(), saved.getContent());
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

    @Override // 단일 조회
    public ScheduleResponseDto findById(Long id) { // find by id 할건데
        Schedule foundSchedule = scheduleRepository.findByIdOrElseThrow(id); // 일단 데이터가 있는지 null인지 체크하고, 있으면 가져오는 메서드를 한번 거쳐서
        return new ScheduleResponseDto(foundSchedule.getId(),foundSchedule.getWriter(), foundSchedule.getTitle(), foundSchedule.getContent()); // 검증된 Schedule인 foundSchedule에서 getter로 가져와서, responseDto로 반환
    }

    @Override // 일정 수정
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto) {
        Schedule foundSchedule = scheduleRepository.findByIdOrElseThrow(id); // 일단 NPE 방지 메서드 담갔다 빼
        foundSchedule.update(requestDto.getTitle(), requestDto.getContent());
        return new ScheduleResponseDto(foundSchedule.getId(), foundSchedule.getWriter(), foundSchedule.getTitle(), foundSchedule.getContent());
    }

    @Override // 일정 삭제
    public void delete(Long id) {
        Schedule foundSchedule = scheduleRepository.findByIdOrElseThrow(id);// 여기도 NPE 방지용 체크
        scheduleRepository.delete(foundSchedule);
    }

}
