package Java0824;

import java.util.Arrays;

public class SortingJob implements Job {
    @Override
    public void doJob(int[] array) {
        Arrays.sort(array);

        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArraysStrategy strategy = new ArraysStrategy();
        strategy.execute(new SortingJob());
    }
}

