package Java0824;

public class MaximumFinderJob implements Job {
    @Override
    public void doJob(int[] array) {
        int max = 0;

        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }

        System.out.printf("최대값 : %d\n", max);
    }

    public static void main(String[] args) {
        ArraysStrategy strategy = new ArraysStrategy();
        strategy.execute(new MaximumFinderJob());
    }
}
