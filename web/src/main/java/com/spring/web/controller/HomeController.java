package com.spring.web.controller;

import com.spring.web.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {

//    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = {"/hi", "/abcd", "/dgsw.do"})
    public String hi() {
        return "hi";
    }

    @RequestMapping("/clock")
    public ModelAndView clock() {
        ModelAndView mv = new ModelAndView("clock");

        SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
        String time = format.format(new Date());
        mv.addObject("now", time);

        Person person = new Person();
        person.setName("김상은");
        person.setAge(6);

        mv.addObject("person", person);

        return mv;
    }


}