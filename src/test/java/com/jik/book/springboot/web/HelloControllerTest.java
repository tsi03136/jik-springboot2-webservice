package com.jik.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행
//여기서는 springRunner라는 스프링 실행자를 사용
//즉, 스프링 부트 테스트와 JUnut 사이에 연결자 역할
@RunWith(SpringRunner.class)

//여러 스프링 테스트 어노테이션 중, Web(spring mvc)에 집중할 수 있는 어노테이션
//여기서는 컨트롤러만 사용하기 때문에 선언
@WebMvcTest
public class HelloControllerTest {

    //스프링이 관리하는 빈(Bean)을 주입
    @Autowired
    //웹 API 테스트할 때 사용, 스프링 MVC 테스트의 시작점
    //이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트 가능
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        //MockMvc를 통해 /hello 주소로 HTTP GET 요청
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}