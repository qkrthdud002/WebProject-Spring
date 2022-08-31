package calculator;

public class Result implements Calculator {

    protected int num1;
    protected int num2;

    @Override
    public void calculate(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void showResult() {
        System.out.println("덧셈");
        System.out.printf("%d + %d = %d\n", this.num1, this.num2, this.num1+num2);
        System.out.println("뺄셈");
        System.out.printf("%d - %d = %d\n", this.num1, this.num2, this.num1-this.num2);
        System.out.println("곱셈");
        System.out.printf("%d * %d = %d\n", this.num1, this.num2, this.num1*this.num2);
        System.out.println("나눗셈");
        System.out.printf("%d / %d = %d\n", this.num1, this.num2, this.num1/this.num2);
    }
}
