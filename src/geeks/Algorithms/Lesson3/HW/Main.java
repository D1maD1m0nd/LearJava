package geeks.Algorithms.Lesson3.HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        createAndConvertArrayToList();
    }

     /*
    Задание 3.1
    На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию.
    Оцените время выполнения преобразования.
     */
    public static void createAndConvertArrayToList(){
        Integer[] arr = new Integer[20];
        fill(arr);
        List<Integer> list1 = new ArrayList<>(Arrays.asList(arr));
        long t1 = System.nanoTime();
        Arrays.asList(arr);
        System.out.println("Время преобразования Array в List " + (System.nanoTime() - t1));
        /*
        На основе списка из задания 3.1 реализуйте основные методы добавления, удаления и получения объекта или элемента из списка.
         */
        t1 = System.nanoTime();
        list1.add(4);
        System.out.println("Оценка времени добавления в ArraysList " + (System.nanoTime() - t1));

        t1 = System.nanoTime();
        list1.remove(1);
        System.out.println("Оценка времени удаления в ArraysList " + (System.nanoTime() - t1));

        t1 = System.nanoTime();
        list1.get(2);
        System.out.println("Оценка времени получения элемента в ArraysList " + (System.nanoTime() - t1));
        System.out.println("Получение элемента списка под #2 " + list1.get(2));

        //Реализуйте простой односвязный список и его базовые методы.
        MyLinkedList<String> list = new MyLinkedList<>();

        list.insert("Artom");
        list.insert("Rim");
        list.insert("Vasya");
        list.insert("Tema");
        list.insert("Max");
        list.insert("Vasek");

        System.out.println(list.find("Max"));
        System.out.println(list.find("Rim"));
        System.out.println(list.find("Artom"));
        System.out.println(list.find("Vasek"));

        list.display(true);
        list.display();

    }
    public static void fill(Integer[] arr){
        Random rand = new Random();
        for (int ai = 0; ai < arr.length; ai++) {
            arr[ai]  =  rand.nextInt(10);
        }
    }

}
