package com.goaldae.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); //이미 생성된 사용자인지 처음 가입시 확인하는 메소드
    //null을 처리할 수 있는 Optional 클래스
}
