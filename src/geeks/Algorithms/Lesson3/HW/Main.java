package geeks.Algorithms.Lesson3.HW;

import geeks.Algorithms.Lesson1.Data;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        createAndConvertArrayToList();
    }

    /*
   Задание 3.1
   На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию.
   Оцените время выполнения преобразования.
    */
    public static void createAndConvertArrayToList() {
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
        MyLinkedListLine<Data> myList = new MyLinkedListLine<>();

        t1 = System.nanoTime();
        myList.insert(new Data(1));
        myList.insert(new Data(2));
        myList.insert(new Data(3));
        myList.insert(new Data(5));
        System.out.println("Добавление элементов в одно список 6 элементов время  " + (System.nanoTime() - t1));

        t1 = System.nanoTime();
        myList.find(new Data(5));
        System.out.println("Поиск односвяз время  " + (System.nanoTime() - t1));
        myList.display();

        //На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
        //Реализуйте список заполненный объектами из вашего класса из задания 1.3

        MyLinkedList<Data> list = new MyLinkedList<>();
        t1 = System.nanoTime();
        list.insert(new Data(2));
        list.insert(new Data(3));
        list.insert(new Data(4));
        list.insert(new Data(5));

        System.out.println("Добавление элементов в двусвязный список 6 элементов время  " + (System.nanoTime() - t1));


        t1 = System.nanoTime();
        list.find(new Data(5));
        System.out.println("поиск элементов в двусвязный список   время  " + (System.nanoTime() - t1));

        list.display(true);

        //Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции итератора.
        ArrayList<String> a = new ArrayList<>();
        a.add("1232");
        a.add("dasdas");


        Iterator<String> iter = a.iterator();
        while(iter.hasNext()){

            System.out.println(iter.next());
        }
    }

    public static void fill(Integer[] arr) {
        Random rand = new Random();
        for (int ai = 0; ai < arr.length; ai++) {
            arr[ai] = rand.nextInt(10);
        }
    }

}
