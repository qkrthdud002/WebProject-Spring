package com.subject.board.boardsubject.member.controller;

import com.subject.board.boardsubject.member.Role;
import com.subject.board.boardsubject.member.dto.MemberLoginDTO;
import com.subject.board.boardsubject.member.entity.MemberEntity;
import com.subject.board.boardsubject.member.repository.MemberRepository;
import com.subject.board.boardsubject.member.service.MemberService;
import com.subject.board.boardsubject.security.RegistryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("member", new MemberLoginDTO());
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("member", new RegistryRequest());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegistryRequest registryRequest) {
        MemberEntity memberEntity = MemberEntity.builder()
                .id(registryRequest.getUserId())
                .password(bCryptPasswordEncoder.encode(registryRequest.getPassword()))
                .role(registryRequest.getRole())
                .build();

        memberRepository.save(memberEntity);

        return "redirect:/member/login";
    }

}
