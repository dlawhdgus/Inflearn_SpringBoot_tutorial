package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService; //의존성 주입(필드) 비추

//    @Autowired //setter injection 단점 : memberService는 public으로 해야함 -> 노출됨, final 없어야 함
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    @Autowired  //멤버 서비스와 연결하기위한 어노테이션
    public MemberController(MemberService memberService) { //의존성 주입  생성자 의존성 주입
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "/members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
