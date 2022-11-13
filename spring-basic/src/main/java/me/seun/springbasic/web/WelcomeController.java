package me.seun.springbasic.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    // 요청을 처리하는 핸들러 메소드
    // 어떤 요청에 매핑이 되는지, 어떤 응답을 내려주는지
    @GetMapping("/")
    public String hello() {
        return "hello";
    }
}
