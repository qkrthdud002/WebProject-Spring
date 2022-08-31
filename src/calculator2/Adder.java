package calculator2;

public class Adder implements Calculator{

    protected int[] operands;

    @Override
    public int calculate() {
        return operands[0] + operands[1];
    }

    @Override
    public void setOperands(int[] values) {
        this.operands = operands;
    }

    @Override
    public void showResult() {
        System.out.printf("%d + %d = %d\n", operands[0], operands[1], calculate());
    }

    @Override
    public int getCountOfOperands() {
        return 2;
    }
}
