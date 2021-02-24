package geeks.Lesson12.HomeWork;

import java.util.Arrays;

public class ThreadArray extends Thread{
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;
    private final float[] arr = new float[SIZE];
    private final float[] part1 = new float[HALF];
    private final float[] part2 = new float[HALF];
    long startTimes;

    @Override
    public void run() {
        try {
            calcExpInThreads();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void fill(){
        Arrays.fill(arr,1f);
    }

    public void calcExpOneThread(){
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] =  (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }
    public void calcExpOneThread(float[]arr){
        for (int i = 0; i < HALF; i++) {
            arr[i] =  (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("конец");
    }

    public synchronized void calcExpInThreads() throws InterruptedException {
        System.out.println(1);
        startTimes = System.currentTimeMillis();
        System.arraycopy(arr, 0, part1, 0, HALF);
        System.arraycopy(arr, HALF, part2, 0, HALF);

        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                calcExpOneThread(part1);
            }
        });
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
    }
    // надо доделать этот метод
    public synchronized void concat(){

        System.arraycopy(part1, 0, arr, 0, HALF);
        System.arraycopy(part2, 0, arr, HALF, HALF);

        //System.out.println(Arrays.toString(part2));
        System.out.println(System.currentTimeMillis() - startTimes);
        System.out.println(Arrays.compare(part1,part2) == 0? "Части равны":"Части не равны");



    }
}
