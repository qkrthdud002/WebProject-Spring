package Java0824;

public class AverageCalculatorJob implements  Job {
    @Override
    public void doJob(int[] array) {
        int total = 0;

        for (int value : array) {
            total += value;
        }

        double average = (double)total / (double)array.length;

        System.out.printf("평균값 : %.2f\n", average);
    }

    public static void main(String[] args) {
        ArraysStrategy strategy = new ArraysStrategy();
        strategy.execute(new AverageCalculatorJob());
    }
}
