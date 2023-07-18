package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired  //멤버 서비스와 연결하기위한 어노테이션
    public MemberController(MemberService memberService) { //의존성 주입
        this.memberService = memberService;
    }
}
