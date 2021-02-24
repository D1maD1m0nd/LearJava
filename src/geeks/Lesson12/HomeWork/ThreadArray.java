package geeks.Lesson12.HomeWork;

import java.util.Arrays;

public class ThreadArray extends Thread {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    /**
     * Метод пересчитвает значения каждого элемента массива по формуле, массивом берется поле arr
     * (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
     */
    public void calcExpOneThread() {
        //Создаем массив
        final float[] arr = new float[SIZE];
        //заполняем единицами
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время в однопотоке: " + (System.currentTimeMillis() - a));
    }

    /**
     * Метод пересчитвает значения каждого элемента массива по формуле
     * (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
     *
     * @param arr массив, который необходимо обработать
     */
    public void calcExpOneThread(float[] arr) {
        for (int i = 0; i < HALF; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    /**
     * Метод вычитываем значения элментов массива в двух потоках, после завершение каждого происходит их объединение
     *
     * @throws InterruptedException
     */
    public void calcExpInThreads() throws InterruptedException {
        //Создаем массив
        final float[] arr = new float[SIZE];
        final float[] part1 = new float[HALF];
        final float[] part2 = new float[HALF];

        //Заполняем единицами
        Arrays.fill(arr, 1);
        //начало отсчета времени
        long startTimes = System.currentTimeMillis();
        //разделяем на две части массив arr
        System.arraycopy(arr, 0, part1, 0, HALF);
        System.arraycopy(arr, HALF, part2, 0, HALF);


        //поток один
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                calcExpOneThread(part1);
            }
        });
        //поток два
        Thread myThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                calcExpOneThread(part2);
            }
        });
        myThread.start();
        myThread1.start();
        myThread.join();
        myThread1.join();
        //дожидаемся завершения потоков, а далее объединяем
        concatTwoPartIntoArray(arr, part1, part2);
        //конец отсчета времени
        System.out.println("Время в двупотоке: " + (System.currentTimeMillis() - startTimes));

    }

    /**
     * Объединяем две части массива между собой в один, частями являются массивы обработанные до этого в потоке
     * part1 & part2
     */
    public void concatTwoPartIntoArray(float[] arr, float[] part1, float[] part2) {
        System.arraycopy(part1, 0, arr, 0, HALF);
        System.arraycopy(part2, 0, arr, HALF, HALF);
    }
}
