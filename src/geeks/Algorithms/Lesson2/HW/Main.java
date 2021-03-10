package geeks.Algorithms.Lesson2.HW;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        testSorted();
    }
    public static void testSorted(){
        int[] arr = new int[50000];
        fill(arr);
        long t1 = System.currentTimeMillis();
        Sorted.includeSorted(arr);
        System.out.println("Выбором " + (System.currentTimeMillis() - t1));
        fill(arr);

        t1 = System.currentTimeMillis();
        Sorted.bubbleSort(arr);
        System.out.println("Пузырьком " + (System.currentTimeMillis() - t1));
    }
    public static void fill(int[]arr){
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(9090990);
        }
    }
}
