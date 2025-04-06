package com.example.spartascheduleapp.repository;

import com.example.spartascheduleapp.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    // interface에는 default 키워드로 메서드 정의 가능 !

    default Schedule findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, id + "는 존재하지 않는 id 입니다."));
                //ResponseStatusException ? HTTP 상태 코드 + 메시지를 같이 던질 수 있음
    };
}
