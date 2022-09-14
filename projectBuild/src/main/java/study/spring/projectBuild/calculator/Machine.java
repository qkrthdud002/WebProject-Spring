package study.spring.projectBuild.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("component")
public class Machine {
    private Calculator calculator;

    @Autowired
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public void execute() {
        Scanner sc = new Scanner(System.in);

        System.out.println("두 정수를 입력하세요 : ");
        int value1 = sc.nextInt();
        int value2 = sc.nextInt();

        int result = calculator.calculate(value1, value2);
        System.out.printf("%d %s %d = %d\n", value1, calculator.getOperator(), value2, result);

        sc.close();
    }

}
