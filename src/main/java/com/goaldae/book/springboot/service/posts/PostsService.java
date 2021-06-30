package com.goaldae.book.springboot.service.posts;

import com.goaldae.book.springboot.domain.posts.Posts;
import com.goaldae.book.springboot.domain.posts.PostsRepository;
import com.goaldae.book.springboot.web.dto.PostsListResponseDto;
import com.goaldae.book.springboot.web.dto.PostsResponseDto;
import com.goaldae.book.springboot.web.dto.PostsSaveRequestDto;
import com.goaldae.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor //@Autowired 없이 생성자로 주입하는 방식
//final이 선언된 필드를 인자값으로 하는 생성자를 생성함
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();//DTO 객체를 Entity로 매핑해서 Repository에서 처리하기
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());//영속성 컨텍스트 엔티티 영구저장
        return id;
    }
    
    //트렌잭션 처리할 것이 없어 따로 어노테이션 붙이지 않음
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        
        return new PostsResponseDto(entity);
    }
    
    @Transactional(readOnly = true) //등록,수정,삭제 기능이 전혀 없는 서비스에서 조회 속도를 개선할 수 있음
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }
    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        //postsById 메소드를 활용하면 id로 삭제할 수도 있음
        postsRepository.delete(posts);
    }
}
