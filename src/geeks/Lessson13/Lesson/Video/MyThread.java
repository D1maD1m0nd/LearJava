package geeks.Lessson13.Lesson.Video;

import java.util.Random;

public class MyThread extends Thread{
        public void run() {
            int w = new Random().nextInt();
            for (int i = 0; i < 30; i++) {
                System.out.println("Покеда " + w);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        }
}
