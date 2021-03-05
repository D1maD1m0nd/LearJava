package geeks.Lessson13.Lesson.Video;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locksample {
    public static void main(String[] args) {
        Lock myLock = new ReentrantLock();
        for (int i = 0; i < 5; i++) {
            final int w = i;
            new Thread(()->{
                System.out.println("Поток " + w + " остановился перед блокировкой");
                myLock.lock();
                try{
                    Thread.sleep(1000);
                    System.out.println("Поток " + w + " зашел в блокировку");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    myLock.unlock();
                    System.out.println("Поток вышел из блокировки");
                }
            }).start();
        }
    }
}
