package com.spring.web.controller;

import com.spring.web.domain.Animal;
import com.spring.web.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/now")
    public String now() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = dateFormat.format(new Date());

        return now;
    }

    @GetMapping("/person")
    public Person person() {
        Person person = new Person();
        person.setName("금현호");
        person.setAge((int)System.currentTimeMillis() % 90 + 10);

        return person;
    }

    @GetMapping("/animal")
    public Animal animal() {
        Animal animal = new Animal();
        animal.setName("기린");
        animal.setAge(30);

        return animal;
    }

}
