package geeks.Lesson11.HomeWork;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
        System.out.println("Числа");
        Array<Integer> elemsInts = new Array<>(new Integer[]{1,2,3,4,5});
        elemsInts.swap(1,2);
        System.out.println(Arrays.toString(elemsInts.getValues()));
        elemsInts.setValues(new Integer[]{1,32,435,5443,2222});
        elemsInts.swap(3,4);
        Integer[] newelements =  elemsInts.getValues();
        System.out.println(Arrays.toString(newelements));
        System.out.println("Строки");
        Array<String> elemsStrings = new Array<>(new String[]{"dasdsad","ewqewqe","ewqewqe","dasdasdasdsdas", "ewqeqw123rertre"});
        elemsStrings.swap(1,2);
        System.out.println(Arrays.toString(elemsStrings.getValues()));


        //2. Написать метод, который преобразует массив в ArrayList;
        System.out.println("Числа");
        System.out.println(elemsInts.arrayToArrayList(new Integer[] {1,2,3,4}).getClass());
        System.out.println("Строки");
        System.out.println(elemsStrings.arrayToArrayList(new String[]{"12323","rewrwer","rewrewr","rewrere"}).getClass());

    }
}
