package geeks.Lessson13.HomeWork;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;


public class MainClass {
    public static final int CARS_COUNT = 4;
    public static boolean WINNER = true;
    //Состояние готовности
    public static final CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
    //Состояние завершения гонки
    public static final CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
    //Состояние проезда через туннель
    public static final Semaphore mySemaphore = new Semaphore(CARS_COUNT/2);
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (Car car : cars) {
            new Thread(car).start();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        try{
            //Дожидаемся конца гонки
            countDownLatch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
