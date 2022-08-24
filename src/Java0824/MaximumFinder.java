package Java0824;

public class MaximumFinder extends ArraysTemplate {
    @Override
    protected void doJob(int[] array) {
        int max = 0;

        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }

        System.out.printf("최대값 : %d\n", max);
    }

    public static void main(String[] args) {
        MaximumFinder maximumFinder = new MaximumFinder();
        maximumFinder.execute();
    }
}
