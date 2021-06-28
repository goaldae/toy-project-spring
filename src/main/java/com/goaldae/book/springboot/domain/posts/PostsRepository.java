package com.goaldae.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//DB Layer 접근자 CRUD 메소드 자동 생성
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
    //규모가 있는 프로젝트에서 데이터 조회는 "조회용 프레임워크"를 또 사용함 ex)querydsl, jooq, Mybatis 등.
    //등록/수정/삭제 등은 SpringDataJpa를 통해 하면 됨.
}

