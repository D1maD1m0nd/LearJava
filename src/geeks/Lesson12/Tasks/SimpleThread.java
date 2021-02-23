package geeks.Lesson12.Tasks;

public class SimpleThread extends Thread{
    @Override
    public void run() {
        myMethod2();
    }

    private void myMethod(){
        System.out.println("Мой метод 1");
        System.out.println("Мой метод 2");
        System.out.println("Мой метод 3");
        System.out.println("Мой метод Конец 1");
    }
    private void myMethod1(){
        System.out.println("Мой метод 2");
        System.out.println("Мой метод 1");
        System.out.println("Мой метод 0");
        System.out.println("Мой метод Конец 2");
    }
    private synchronized void myMethod2(){
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                myMethod();
            }
        });
        Thread myThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                myMethod1();
            }
        });
        myThread.start();
        myThread1.start();
    }
    private synchronized void myMethod3(){
        System.out.println("я выполнился после всего");
    }
}
