package com.spring.web.controller;

import com.spring.web.domain.Member;
import com.spring.web.domain.NameBookPost;
import com.spring.web.domain.Person;
import com.spring.web.service.MemberService;
import com.spring.web.service.NameBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {

    private NameBookService nameBookService;

    @Autowired
    public void setNameBookService(NameBookService nameBookService) {
        this.nameBookService = nameBookService;
    }

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

    @GetMapping("/namebook/write")
    public String nameBook() {
        return "namebook/write";
    }

    @PostMapping("/namebook/write-save")
    public String namebookAdd(
            @RequestParam("writer") String writer,
            @RequestParam("content") String content
    ) {

        NameBookPost post = new NameBookPost();
        post.setWriter(writer);
        post.setContent(content);

        nameBookService.add(post);

        return "namebook/write-save";
    }

}
