package com.spring.web.controller;

import com.spring.web.domain.Member;
import com.spring.web.service.MemberService;
import com.spring.web.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/user")
@Controller
public class SignInController {

    private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/signin")
    public String signin() {

        System.out.println("입력 완료");

        return "signin";
    }

    @PostMapping("/signin-result")
    @ResponseBody
    public ModelAndView signinResult(@RequestParam("username") String username,
                                     @RequestParam("id") String id,
//                                     @RequestParam("password") String password,
                                     @RequestParam("cityName") String cityName) {
        ModelAndView mv = new ModelAndView("signin-result");

        /* 데이터베이스에 아이디, 이름, 도시를 저장한다. */

        Member member = new Member();
        member.setId(id);
        member.setId(username);
        member.setId(cityName);

        member = memberService.register(member);

        mv.addObject("member", member);

        return mv;
    }

}
