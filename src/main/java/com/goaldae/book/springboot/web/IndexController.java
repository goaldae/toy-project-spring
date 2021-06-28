package com.goaldae.book.springboot.web;

import com.goaldae.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "index"; //앞 경로와 뒤 파일 확장자는 자동으로 붙음.
    }

    @GetMapping("posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
