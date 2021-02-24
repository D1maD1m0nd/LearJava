package geeks.Lesson12.HomeWork;

public class App {
    public static void main(String[] args) throws InterruptedException {
        ThreadArray newArray = new ThreadArray();
        //для однопотока
        newArray.calcExpOneThread();
        //для многопотка
        newArray.calcExpInThreads();
    }
}
