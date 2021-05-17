package com.goaldae.book.springboot.service.posts;

import com.goaldae.book.springboot.domain.posts.PostsRepository;
import com.goaldae.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();//DTO 객체를 Entity로 매핑해서 Repository에서 처리하기
    }
}
