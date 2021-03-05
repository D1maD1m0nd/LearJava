package geeks.Lessson13.Lesson.Video;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLenchSample {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 3;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int w = i;
            new Thread(()->{
                try{
                    Thread.sleep(2000 + new Random().nextInt(5000));
                    System.out.println("Поток " + w + " завершил работу");
                    countDownLatch.countDown();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }).start();
        }
        boolean result = countDownLatch.await(5, TimeUnit.SECONDS);
        if(result){
            System.out.println("Все потоки завершили свою работу");
        }else{
            System.out.println("Не все потоки завершили свою работу");
        }
        System.out.println("Основной поток закончил свое выполнение");
    }
}
