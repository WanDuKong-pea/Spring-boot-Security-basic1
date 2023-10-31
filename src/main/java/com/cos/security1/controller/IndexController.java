package com.cos.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //View를 리턴할 것.
public class IndexController {

    //localhost:8080
    //인가된 사용자만 접근 가능하게
    @GetMapping({"","/"})
    public String index(){
        //머스테치 기본 폴더 경로 src/main/resources/
        //뷰 리졸버 설정: templates (prefix), .mustache(suffix)
        //application.properties에 설정되어 있음
            //spring.mvc.view.prefix=/templates/
            //spring.mvc.view.suffix=.mustache
            //생략 해도 됨 -> Mustache가 Spring에서 기본적으로 지원하는 템플릿이기 때문
        return "index"; //src/main/resources/templates/index.mustache -> Config 파일 만들기
    }

    //로그인한 user만 접근 가능하게
    @GetMapping("/uesr")
    public @ResponseBody String user(){
        return "user";
    }

    //admin 권한을 가진 사용자만 접근 가능하게
    @GetMapping("/admin")
    public @ResponseBody String admin(){
        return "admin";
    }

    //로그인 user중 매니저에 해당하는 user만 접근 가능하게
    @GetMapping("/manager")
    public @ResponseBody String manager(){
        return "manager";
    }

    //스프링 시큐리티에서 해당 리소스를 낚아챔 -> SecurityConfig 파일 생성후 낚아채지 않음
    @GetMapping("/login")
    public @ResponseBody  String login(){
        return "login";
    }

    @GetMapping("/join")
    public @ResponseBody String join(){
        return "join";
    }

    @GetMapping("/joinProc")
    public @ResponseBody String joinProc(){
        return "회원 가입 완료";
    }
}
