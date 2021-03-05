package geeks.Lessson13.Lesson.Video;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CicledBarrieSample {
    public static void main(String[] args) {
        CyclicBarrier myCycledBarrier = new CyclicBarrier(3);
        for (int i = 0; i < 4; i++) {
            final int w = i;
            new Thread(()->{

                try {
                    System.out.println("Поток" + w + "Поток начинает подготовку");
                    Thread.sleep(1000 + new Random().nextInt(2000));
                    System.out.println("Поток закончил " + w +  " подготовку");
                    myCycledBarrier.await();
                    System.out.println("Поток закончил " + w +  " дождался выполнения остальных");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
