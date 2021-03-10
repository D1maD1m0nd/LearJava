package geeks.Algorithms.Lesson2.HW;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных или ссылочных типов данных.
//        Выполните обращение к массиву и базовые операции класса Arrays.
        int[] arr = new int[10000000];
        String[] strs = new String[22200];
        int[] arrCopy;
        long t1 = System.nanoTime();
        //заполняем единицами
        Arrays.fill(arr,1);
        //копируем
        arrCopy = Arrays.copyOf(arr,arr.length);
        //сравнение массивов
        System.out.println(Arrays.equals(arr,arrCopy));
        System.out.println("Время выполнения базовых операций массивов " + (System.nanoTime() - t1));

//        На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
//       Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(),
//       при необходимости расширьте уже существующий массив данных.

        //заполняем рандомными значениями
        fill(strs);

        strs[4] = "То что я ищу";
        Arrays.sort(strs);
        t1 = System.nanoTime();
        System.out.println(Search.binnarySearch("То что я ищу",strs));
        System.out.println("Бинарный поиск строки " + (System.nanoTime() - t1));

        fill(arr);
        Arrays.sort(arr);
        t1 = System.nanoTime();
        System.out.println(Search.binnarySearch(arr,0));
        System.out.println("Бинарный поиск числа " + (System.nanoTime() - t1));
    }
    public static void testSorted(){
        int[] arr = new int[50];
        fill(arr);
        long t1 = System.nanoTime();;
        Sorted.choiceSorted(arr);
        System.out.println("Выбором " + (System.nanoTime() - t1));
        fill(arr);

        t1 = System.nanoTime();
        Sorted.bubbleSort(arr);
        System.out.println("Пузырьком " + (System.nanoTime() - t1));

        t1 = System.nanoTime() ;
        Sorted.includeSorted(arr);
        System.out.println("Вставками " + (System.nanoTime() - t1));
    }
    public static void fill(int[]arr){
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(9);
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

            str.append((char) rand.nextInt(1200));
        }
        return new String(str);
    }
}
