package com.spring.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/subject")
@RestController
public class SubjectController {

    @GetMapping("/addsub")
    public String addsub1(@RequestParam(value = "value1", defaultValue = " ") int value1,
                          @RequestParam(value = "value2", defaultValue = " ") int value2) {

//        SubjectAdd subjectAdd = new SubjectAdd();
//        subjectAdd.setValue1(3);
//        subjectAdd.setVlaue2(2);

        System.out.printf("%d + %d = %d", value1, value2, value1 + value2);

        return "/addsub";
    }

}
