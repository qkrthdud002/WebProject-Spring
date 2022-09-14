package study.spring.projectBuild.calculator;

public class Adder implements Calculator{

    @Override
    public int calculate(int value1, int value2) {
        return value1 + value2;
    }

    @Override
    public String getOperator() {
        return "+";
    }
}
