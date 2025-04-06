package com.example.spartascheduleapp.repository;

import com.example.spartascheduleapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface UserRepository extends JpaRepository<User, Long> {

    default User findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, id + "는 존재하지 않는 id 입니다."));
    };

}
