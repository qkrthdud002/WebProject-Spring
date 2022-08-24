package Java0824;

import java.util.Random;
import java.util.Scanner;

public abstract class ArraysTemplate {
    public void execute() {
        // 배열의 크기를 입력 받는다.
        int size = inputSize();

        // 배열을 생성한다.
        int[] array = new int[size];

        // 난수를 이용해서 배열의 값을 채운다.
        fillValues(array);

        // 개별적인 작업을 수행한다.
        doJob(array);
    }

    protected abstract void doJob(int[] array);

    private int inputSize() {
        System.out.println("배열의 크기를 입력하세요.");

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.close();

        return size;
    }

    private void fillValues(int[] array) {
        Random random = new Random();

        for (int i = 0 ; i < array.length ; i++) {
            array[i] = random.nextInt(10000);
        }
    }
}
