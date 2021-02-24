package geeks.Lesson12.Tasks;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    main.method1();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Thread myThread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    main.method2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });


        myThread.start();
        myThread2.start();

    }
    public synchronized void method1() throws InterruptedException{
        System.out.println("M1");
        for (int i = 0; i < 5; i++) {
            System.out.println("M1 " + i);
            Thread.sleep(1000);
        }
    }

    public synchronized void method2() throws InterruptedException{
        System.out.println("M2");
        for (int i = 0; i < 5; i++) {
            System.out.println("M2 " + i);
            Thread.sleep(1000);
        }
    }
}
