package com.spring.web.controller;

import com.spring.web.domain.Calculation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestfulController {

    @GetMapping("/add")
    public Calculation add(@RequestParam("op1") int op1, @RequestParam("op2") int op2) {
        Calculation calculation = new Calculation();

        calculation.setOperand1(op1);
        calculation.setOperand2(op2);
        calculation.setOperator("+");
        calculation.setResult(op1 + op2);

        return calculation;
    }

}
