package geeks.Lessson13.HomeWork;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private final Race race;
    private final int speed;
    private final String name;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run(){
        Lock lockCarIntoFinish = new ReentrantLock();
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            MainClass.cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //System.out.println("Гонка началась");
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        //Тут я не уверен, но должно блокровать поток, что бы исправить момент с двумя победител
        //По крайней мере такого больше я не встречал, после внесения этого изменения
        lockCarIntoFinish.lock();
        if(MainClass.WINNER){
            MainClass.WINNER = false;
            System.out.println("WIN!!! " + "Победителем становится " + name);
        }else{
            System.out.println("Finish " + "Участник " + name + " Финишировал!!!");
        }
        lockCarIntoFinish.unlock();
        //Уменьшаем каждый раз, когда участник финшировал
        MainClass.countDownLatch.countDown();
    }
}
