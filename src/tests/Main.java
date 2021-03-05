package tests;

import java.util.Arrays;

public class Main {


    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] ARR = new float[SIZE];

    public static void main(String[] args) throws InterruptedException {


        fillArrayWithFormula();
        fillArrayWithFormulaWithThreads();

    }


    public static void fillArrayWithFormula() {

        Arrays.fill(ARR, 1.0f);

        long t1 = System.currentTimeMillis();

        for (int i = 0; i < SIZE; i++) {
            ARR[i] = (float) (ARR[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - t1);
        System.out.println("элемент середины \n");
        System.out.println(ARR[HALF]);

    }


    public static void fillArrayWithFormulaWithThreads() throws InterruptedException {
        Arrays.fill(ARR, 1.0f);
        long t1 = System.currentTimeMillis();

        float[] arr1 = Arrays.copyOfRange(ARR, 0, HALF);
        float[] arr2 = Arrays.copyOfRange(ARR, HALF, SIZE);

        Thread thread1 = new Thread(new Runnable() {
            @Override

            public void run() {
                for (int i = 0; i < HALF; i++) {
                    arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < HALF; i++) {
                    arr2[i] = (float) (arr2[i] * Math.sin(0.2f + (HALF + i) / 5) * Math.cos(0.2f + (HALF + i) / 5) * Math.cos(0.4f + (HALF + i) / 2));
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.arraycopy(arr1, 0, ARR, 0, HALF);
        System.arraycopy(arr2, 0, ARR, HALF, HALF);
        System.out.println(System.currentTimeMillis() - t1);
        System.out.println("элемент середины ");
        System.out.println(ARR[HALF]);

    }
}