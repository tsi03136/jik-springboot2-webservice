package com.jik.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//Application 클래스는 앞으로 만들 프로젝트의 메인 클래스

//@SpringBootApplication 은 항상 최상단에 위치할 것
@SpringBootApplication
@EnableJpaAuditing //JPA Auditing 활성화
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
