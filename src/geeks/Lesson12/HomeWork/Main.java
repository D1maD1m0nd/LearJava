package geeks.Lesson12.HomeWork;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ThreadArray newArray = new ThreadArray();

        //для однопотока
        newArray.calcExpOneThread();
        newArray.start();
    }
}
