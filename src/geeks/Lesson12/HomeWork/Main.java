package geeks.Lesson12.HomeWork;

public class Main {
    public static void main(String[] args) {
        ThreadArray newArray = new ThreadArray();
        newArray.fill();
        newArray.calcExpOneThread();
        newArray.fill();
        Thread threadConcatArray = new Thread(new Runnable() {
            @Override
            public void run() {
                newArray.concat();
            }
        });
        newArray.start();
        threadConcatArray.start();
    }
}
