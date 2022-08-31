package calculator;

import java.util.Scanner;

public class Calculate {

    protected Scanner sc;

    public Calculate() {
        sc = new Scanner(System.in);
    }

    public void execute(Calculator calculator) {
        while(true) {
            int num1 = inputNumber();
            int num2 = inputNumber();

            if(num1 == 0 || num2 == 0){
                break;
            }

            calculator.calculate(num1, num2);
            calculator.showResult();

        }
    }

    protected int inputNumber() {
        System.out.println("두 수를 입력하세요.");
        return sc.nextInt();
    }

}
