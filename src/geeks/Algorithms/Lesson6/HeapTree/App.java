package geeks.Algorithms.Lesson6.HeapTree;

import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        int[] arr;
        Random rand = new Random();
        arr = new int[10];

        for (int i = 0; i <arr.length ; i++) {
            arr[i] = rand.nextInt(10);
        }

        System.out.println(Arrays.toString(arr));
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
