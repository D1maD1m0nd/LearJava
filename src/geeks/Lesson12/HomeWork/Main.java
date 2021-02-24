package geeks.Lesson12.HomeWork;

public class Main {
    public static void main(String[] args) {
        ThreadArray newArray = new ThreadArray();
        //для однопотока
        newArray.calcExpOneThread();
        //для многопотка
        newArray.start();
    }
}
