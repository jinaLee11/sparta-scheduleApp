package com.example.spartascheduleapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

//  user 와 schedule 테이블에서 공통으로 가지고 있는 createdAt(작성일)&updatedAt(수정일) 컬럼 만들어주는 용도의 엔티티

@Getter
@MappedSuperclass // 이 어노테이션이 선언된 클래스를 상속받는 엔티티에 공통 매핑정보 제공
@EntityListeners(AbstractMethodError.class)
public abstract class BaseEntity {

    @CreatedDate // 생성시점의 날짜 자동기록
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate // 수정시점의 날짜 자동 기록
    private LocalDateTime modifiedAt;

}
