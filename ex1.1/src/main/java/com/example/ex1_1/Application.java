package com.example.ex1_1;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

// Spring Boot 상 HelloWorld
@SpringBootApplication // 이 클래스를 스프링 부트 서비스의 진입점으로 스프링 부트에 지정
@RestController // 이 클래스의 코드를 Spring RestController로 노출하도록 스프링 부트에 지정
@RequestMapping(value = "hello") // 이 어플리케이션에서 노출되는 모든 URL 앞에 /hello가 붙는다.
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping(value="/{firstName}") // firstName(@PathVariable 사용)과 lastName(@RequestParam 사용) 이 두개의 매개변수를 받는
    //GET 동사 REST 엔드포인트를 노출한다
    public String helloGET(
            @PathVariable("firstName") String firstName, // firstName, lastName매개변수를 hello 메서드의 변수로 매핑한다.
            @RequestParam("lastName") String lastName) {
        return String.format("{\"message\":\"Hello %s %s\"}", firstName, lastName);
    }

    @PostMapping
    public String helloPOST(@RequestBody HelloRequest request) {
        return String.format("{\"message\":\"Hello %s %s\"}", request.getFirstName(), request.getLastName());
        // 직접 간단한 JSON 문자열을 만들어 반환한다
    }
}
@Data
class HelloRequest { // 사용자가 전송한 JSON구조체 필드를 저장한다
    private String firstName;
    private String lastName;
}
