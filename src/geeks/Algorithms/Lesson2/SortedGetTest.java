package geeks.Algorithms.Lesson2;

import java.util.Random;

public class SortedGetTest {
    public static void main(String[] args) {
        int[] a = new int[3000000];
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(5000000);
        }
        SortedGet.gettingSort(a);
    }
}
