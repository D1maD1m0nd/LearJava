package geeks.Algorithms.Lesson8;


import geeks.Lessson13.HomeWork.Race;

import java.util.Random;

public class Main {

    public static void hashFunc(int key, int f){
        System.out.println(key % f);
    }
    //На основе данных массива из задания 2.3 реализуйте хеш-таблицу с помощью открытой адресации, а конкретнее метода линейного пробирования
    public static void linerHash(){
        Item aDataItem;
        int aKey;
        int[] arr = geeks.Algorithms.Lesson2.HW.Main.arr;
        int size = arr.length;

        HashTable hTable = new HashTable(size);
        Random rand = new Random();

        for (int i = 0; i < arr.length/2; i++) {
            aKey = rand.nextInt(999);
            aDataItem = new Item(aKey);
            hTable.insert(aDataItem);
        }

        hTable.insert(new Item(999));
        hTable.insert(new Item(203));

        hTable.display();

        hashFunc(999,66);
        System.out.println(hTable.find(999).getKey());
        System.out.println(hTable.delete(203));
    }
    public static void doubleHash(){
        Item aDataItem;
        int aKey;
        int[] arr = geeks.Algorithms.Lesson2.HW.Main.arr;
        int size = arr.length;

        HashTable hTable = new HashTable(size);
        Random rand = new Random();

        for (int i = 0; i < 15; i++) {
            aKey = rand.nextInt(999);
            aDataItem = new Item(aKey);
            hTable.insertD(aDataItem);
        }

        hTable.insertD(new Item(999));
        hTable.insertD(new Item(203));

        hTable.display();

        hashFunc(999,66);
        System.out.println(hTable.findD(999).getKey());
        System.out.println(hTable.deleteD(203));
    }
    public static void main(String[] args) {
        //Приведите пример использование хеш-таблиц.
        //Таблица с паролями, справочник ФИО - НОМЕР
        //------------------------------------------------
        //Приведите примеры ключей и коллизий.
        //К нескольим логинам может быть привязано несколько паролей
        //------------------------------------------------
        //Приведите примеры популярных и эффективных хеш-функций.
        //«Хеш-функции», основанные на умножении
        //«Хеш-функции», основанные на делении
        //Универсальное хеширование
        //------------------------------------------------
        long t;
        t = System.nanoTime();
        doubleHash();
        System.out.println("Время выполнения базовых методов двойного хэширования");
        System.out.println(System.nanoTime() - t);
        System.out.println("-00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000-");
        t = System.nanoTime();
        linerHash();
        System.out.println("Время выполнения базовых методов линейного пробирования");
        System.out.println(System.nanoTime() - t);
    }
}
