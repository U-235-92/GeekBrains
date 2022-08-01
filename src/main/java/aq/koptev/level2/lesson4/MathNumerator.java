package aq.koptev.level2.lesson4;

import java.util.Arrays;

public class MathNumerator {
    private static final int SIZE = 10000000;
    private static final int HALF_SIZE = SIZE / 2;
    private static final int MIDDLE_INDEX = SIZE / 2;
    private float[] numbers;

    public  MathNumerator() {
        numbers = new float[SIZE];
        Arrays.fill(numbers, 1);
    }

    public void calculateNoThread() {
        System.out.println("Вычисление значений массива размером " + SIZE + " без использования потоков");
        float[] numbersCopy = new float[SIZE];
        System.arraycopy(numbers, 0, numbersCopy, 0, SIZE);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            numbersCopy[i] = (float)(numbersCopy[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время работы без преминения потоков составило: " + (endTime - startTime) + " мс.");
    }

    public void calculateWithThread() {
        System.out.println("Вычисление значений массива размером " + SIZE + " с использованием потоков");
        float[] numbersCopy = new float[SIZE];
        System.arraycopy(numbers, 0, numbersCopy, 0, SIZE);
        float[] left = new float[HALF_SIZE];
        float[] right = new float[HALF_SIZE];
        long startTime = System.currentTimeMillis();
        System.arraycopy(numbers, 0, left, 0, HALF_SIZE);
        System.arraycopy(numbers, MIDDLE_INDEX, right, 0, HALF_SIZE);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < HALF_SIZE; i++) {
                left[i] = (float)(left[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < HALF_SIZE; i++) {
                right[i] = (float)(right[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
            }
        });
        t1.start();
        t2.start();
        Thread.yield();
        System.arraycopy(left, 0, numbersCopy, 0, HALF_SIZE);
        System.arraycopy(right, 0, numbersCopy, MIDDLE_INDEX, HALF_SIZE);
        long endTime = System.currentTimeMillis();
        System.out.println("Время работы с применением потоков составило: " + (endTime - startTime) + " мс.");
    }
}
