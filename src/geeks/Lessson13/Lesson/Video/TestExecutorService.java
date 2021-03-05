package geeks.Lessson13.Lesson.Video;

import java.util.Random;
import java.util.concurrent.*;

public class TestExecutorService {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();
        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(10);
        ExecutorService cashedExecutorService = Executors.newCachedThreadPool();

        Thread myThread = new MyThread();
        Future result = singleExecutorService.submit(myThread);



        try {
            result.get(4, TimeUnit.SECONDS);//ожидаем выполнения
        }catch (TimeoutException e){
            System.out.println("время вышло");
            result.cancel(true);
        }
        System.out.println(result.isDone());


        Future<String> result1 = singleExecutorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception{
                Thread.sleep(3000);
                return "Вывод информации в консоль";
            }
        });

        System.out.println(result1.get());
//        Runnable myTask = new Runnable() {
//            @Override
//            public void run() {
//                int w = new Random().nextInt();
//                for (int i = 0; i < 5; i++) {
//                    System.out.println("Привет " + w);
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        singleExecutorService.execute(myTask);
//        singleExecutorService.execute(myTask);
////        singleExecutorService.execute(myTask);
////        singleExecutorService.execute(myTask);
//
//        Runnable myTask1 = new Runnable() {
//            @Override
//            public void run() {
//                int w = new Random().nextInt();
//                for (int i = 0; i < 5; i++) {
//                    System.out.println("Покеда " + w);
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        fixedExecutorService.execute(myTask1);
//
//
//        Runnable myTask2 = new Runnable() {
//            @Override
//            public void run() {
//                int w = new Random().nextInt();
//                for (int i = 0; i < 12; i++) {
//                    System.out.println("Покеда " + i);
//
//                }
//            }
//        };
//
//        cashedExecutorService.execute(myTask2);
    }
}
