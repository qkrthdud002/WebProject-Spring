package Java0824;

import java.util.Arrays;

public class Sorting extends ArraysTemplate {
    @Override
    protected void doJob(int[] array) {
        Arrays.sort(array);

        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        sorting.execute();
    }
}
