package com.spring.web.controller;

import com.spring.web.domain.SignIn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/user")
@Controller
public class SignInController {

    @GetMapping("/signin")
    public String signin() {

        System.out.println("입력 완료");

        return "signin";
    }

    @PostMapping("/signin-result")
    @ResponseBody
    public ModelAndView signinResult(@RequestParam("id") String id,
                                     @RequestParam("username") String username,
                                     @RequestParam("cityName") String cityName) {
        ModelAndView mv = new ModelAndView("signin-result");

        mv.addObject("id", id);
        mv.addObject("username", username);
        mv.addObject("cityName", cityName);

        return mv;
    }

}
