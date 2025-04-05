package com.example.spartascheduleapp.entity;

import jakarta.persistence.*;
import lombok.Getter;

// schedule table

@Getter
@Entity // 엔티티로 쓰겠다 !
@Table(name = "schedule")
public class Schedule extends BaseEntity { //extends BaseEntity 해줘야 작성일 수정일도 쓸 수 있음
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 식별자 값 자동 증가
    private Long id;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String title;

    private String contents;

    // 연관관계 설정
    @ManyToOne // 단방향 (schedule N : User 1)
    @JoinColumn(name = "user_id") // user의 id를 FK로 해서 컬럼 두개 쪼인해주겠다!
    private User user;

    public Schedule() {
        /** JPA는 기본 생성자 필요하대용
         왜 ?? JPA는 기본 생성자가 없으면 객체를 만들 수 없다 !
         findAll() 나 findById() 같은 메서드를 호출하면 DB에서 데이터를 꺼내와서 엔티티 객체로 바꿔줘야 하는데
         그 때 내부적으로 기본 생성자를 거쳐서 동작한대요 => 그러니까 꼭 필요, 없으면 에러남
         */
    }

    public Schedule(String writer, String title, String contents) {
        this.writer = writer;
        this.title = title;
        this.contents = contents;
    }

}
