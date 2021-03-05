package geeks.Lessson13.Lesson.Video;

import java.util.concurrent.Semaphore;

public class SemaphoreSample {
    public static void main(String[] args) {
        Semaphore mySemaphore = new Semaphore(2);
        for (int i = 0; i < 5; i++) {
            final int w = i;
            new Thread(()->{
                System.out.println("Поток " + w + " остановился перед семафором");
                try{
                    Thread.sleep(3000);
                    mySemaphore.acquire();
                    Thread.sleep(3000);
                    System.out.println("Поток " + w + " занял семафор");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    mySemaphore.release();
                }
            }).start();
        }
    }
}
