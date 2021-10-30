package com.jik.book.springboot.web;

import com.jik.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//컨트롤러를, JSON을 반환하는 컨트롤러로 만듬
@RestController
public class HelloController {

    //HTTP Method인 Get의 요청을 받을 수 있는 API로 만듦
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto (@RequestParam("name") String name,
                                      @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}

