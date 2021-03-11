package geeks.Algorithms.Lesson2.HW;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных или ссылочных типов данных.
//        Выполните обращение к массиву и базовые операции класса Arrays.
        int[] arr = new int[400];
        int[] arrCopy;
        String[] arrStrCopy;
        long t1 = System.nanoTime();
        //заполняем единицами
        Arrays.fill(arr,1);
        //копируем
        arrCopy = Arrays.copyOf(arr,arr.length);
        //сравнение массивов
        System.out.println(Arrays.equals(arr,arrCopy));
        System.out.println("Время выполнения базовых операций массивов " + (System.nanoTime() - t1));

        fill(arr);

        t1 = System.nanoTime();
        Sorted.bubbleSort(arr);
        System.out.println("Время сортировки чисел методом пузырьковой сортировки " + (System.nanoTime() - t1));

        fill(arr);

        t1 = System.nanoTime();
        //сортировка выбором
        Sorted.choiceSorted(arr);
        System.out.println("Время сортировки чисел методом выбором " + (System.nanoTime() - t1));

        fill(arr);
        t1 = System.nanoTime();
        //сортировка вставками
        Sorted.includeSorted(arr);
        System.out.println("Время сортировки чисел методом вставками " + (System.nanoTime() - t1));

        fill(arr);
        arr[(arr.length - 1)/2] = 32132;
        t1 = System.nanoTime();
        Arrays.sort(arr);
        System.out.println("Время сортировки чисел методом Arrays.sort " + (System.nanoTime() - t1));

        t1 = System.nanoTime();
        Search.linerSearch(arr,32132);
        System.out.println("Линейный поиск числа занял " + (System.nanoTime() - t1));


        t1 = System.nanoTime();
        Search.binnarySearch(arr,32132);
        System.out.println("Бинарный поиск числа занял " + (System.nanoTime() - t1));

        t1 = System.nanoTime();
        Arrays.binarySearch(arr,32132);
        System.out.println("Бинарный поиск встроенным методом числа занял " + (System.nanoTime() - t1));





    }

    public static void fill(int[]arr){
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100000);
        }
    }

    public static void fill(String[]arr){
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = genRandStr(rand.nextInt(2));
        }
    }
    public static String genRandStr(int bound){
        StringBuilder str = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < bound; i++) {

            str.append((char) rand.nextInt(7));
        }
        return new String(str);
    }
}
