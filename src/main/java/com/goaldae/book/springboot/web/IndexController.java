package com.goaldae.book.springboot.web;

import com.goaldae.book.springboot.config.auth.LoginUser;
import com.goaldae.book.springboot.config.auth.dto.SessionUser;
import com.goaldae.book.springboot.service.posts.PostsService;
import com.goaldae.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){

        model.addAttribute("posts", postsService.findAllDesc());

        if(user!=null){ //로그인 유저가 있으면 템플릿에 넘기기
            model.addAttribute("userName", user.getName());
        }
        return "index"; //앞 경로와 뒤 파일 확장자는 자동으로 붙음.
    }

    @GetMapping("posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
