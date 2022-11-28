package me.seun.springbasic.jdbc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // POST http://localhost:8080/members?name=... -> 회원 생성해주기!
    @ResponseBody
    @PostMapping("/members")
    public String createMember(@RequestParam String name) {
        memberService.save(name);
        return "ok";
    }

    // GET http://localhost:8080/members -> 회원 생성화면 반환해주기!
    @GetMapping("/members")
    public String showMemberCreateForm() {
        return "memberCreate";
    }

    // GET http://localhost:8080/members/{id} -> 특정 회원 정보 반환해주기
    @GetMapping("/members/{id}")
    public String showMemberInfo(@PathVariable Long id, Model model) {
        Member member = memberService.findById(id);
        model.addAttribute("member", member);
        return "memberInfo";
    }
}
