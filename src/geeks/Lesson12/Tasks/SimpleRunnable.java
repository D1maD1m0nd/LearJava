package geeks.Lesson12.Tasks;

public class SimpleRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Я новый поток через интерфейс");
    }
}
