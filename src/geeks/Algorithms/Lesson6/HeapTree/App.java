package geeks.Algorithms.Lesson6.HeapTree;

import geeks.Algorithms.Lesson2.HW.Sorted;

import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        int[] arr;
        Random rand = new Random();
        arr = new int[400];

        for (int i = 0; i <arr.length ; i++) {
            arr[i] = rand.nextInt(12345678);
        }
        long timeHeapSort;
        long t = System.nanoTime();
        HeapSort.sort(arr);
        timeHeapSort = System.nanoTime() - t;


        long end ;
        t = System.nanoTime();
        Sorted.bubbleSort(arr);
        end  = System.nanoTime();
        System.out.println("Сортировка пузырьком заняла " + (end - t) + " а HeapSort "  + timeHeapSort);

        t = System.nanoTime();
        Sorted.includeSorted(arr);
        end  = System.nanoTime();
        System.out.println("Сортировка вставками заняла " + (end - t) + " а HeapSort "  + timeHeapSort);

        t = System.nanoTime();
        Sorted.choiceSorted(arr);
        end  = System.nanoTime();
        System.out.println("Сортировка выбором заняла " + (end - t) + " а HeapSort "  + timeHeapSort);

        t = System.nanoTime();
        Arrays.sort(arr);
        end  = System.nanoTime();
        System.out.println("Сортировка выбором заняла " + (end - t) + " а HeapSort "  + timeHeapSort);
    }
}
