package geeks.Algorithms.Lesson3;

import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list3 = new LinkedList<>();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>(list1);

        list1.add("Привет");
        list1.add("Я");
        list1.add("Ценитель");

        list3.add("Привет");
        list3.add("Я");
        list3.add("Ценитель");

        System.out.println(list1);
        System.out.println(list3);
        list3.add(1,"321312");
        list3.addFirst("312321");
        list3.addLast("1111111111111111");
        list1.add(1,"Добавили элемент на позицию");
        System.out.println(list1);
        System.out.println(list3);
        list1.set(1, "Чее серьезно,да серьезно");
        list3.set(1,"ewqewq");
        System.out.println(list1);
        System.out.println(list3.peekFirst());
        System.out.println(list3.peekLast());

        ArrayList<ArrObj> arrObjs = new ArrayList<>();
        arrObjs.add(new ArrObj(1,2));
        arrObjs.add(new ArrObj(1,3));
        arrObjs.add(new ArrObj(1,4));
        arrObjs.add(new ArrObj(1,5));
    }
}
