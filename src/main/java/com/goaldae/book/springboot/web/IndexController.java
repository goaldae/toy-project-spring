package com.goaldae.book.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index"; //앞 경로와 뒤 파일 확장자는 자동으로 붙음.
    }

    @GetMapping("posts/save")
    public String postsSave(){
        return "posts-save";
    }

}
