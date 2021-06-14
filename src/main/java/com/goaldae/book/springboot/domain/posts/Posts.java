package com.goaldae.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //lombok은 필수 어노테이션이 아님 -> 필수 어노테이션일수록 위로
@NoArgsConstructor //기본 생성자 자동 추가
@Entity //실제 DB와 매칭될 클래스 .. Entity 클래스
public class Posts {//언더스코어 네이밍으로 테이블 이름을 매칭함

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성규칙 .. GenerationType.IDENTITY을 추가해야만 auto_increment됨
    private Long id;

    @Column(length = 500, nullable = false) //문자열의 경우 255가 기본
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }



}
