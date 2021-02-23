package geeks.Lesson12.Tasks;

public class Main {
    public static void main(String[] args) {

        SimpleThread thread = new SimpleThread();
        SimpleThread thread1 = new SimpleThread();
        thread.start();
        thread1.start();
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
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        });
        System.out.println("Принт");
//        myThread.start();
//        myThread2.start();

    }
    public void method1() throws InterruptedException{
        System.out.println("M1");
        for (int i = 0; i < 5; i++) {
            System.out.println("M1 " + i);
            Thread.sleep(1000);
        }
    }

    public void method2() throws InterruptedException{
        System.out.println("M2");
        for (int i = 0; i < 5; i++) {
            System.out.println("M2 " + i);
            Thread.sleep(1000);
        }
    }
}
