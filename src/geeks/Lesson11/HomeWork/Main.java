package geeks.Lesson11.HomeWork;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
        Integer[] ints = new Integer[]{1,2,3,4,5};
        String[] strings = new String[]{"o1","p2","e3","g4"};
        System.out.println("Свапы");
        ;
        System.out.println("Числа до " + Arrays.toString(ints));
        System.out.println("Строки до " + Arrays.toString(strings));
        swap(ints,1,2);
        swap(strings,3,2);
        System.out.println("Числа после " + Arrays.toString(ints));
        System.out.println("Строки после " + Arrays.toString(strings));

        //2. Написать метод, который преобразует массив в ArrayList;
        System.out.println("Числа");
        System.out.println(arrayToArrayList(ints).getClass());
        System.out.println("Строки");
        System.out.println(arrayToArrayList(strings).getClass());


        //Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
        //Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        Box<Apple> box1 = new Box<>();
        box1.add(new Apple());
        box1.add(new Apple());
        box1.add(new Apple());

        Box<Apple> box2 = new Box<>();
        box2.add(new Apple());
        box2.add(new Apple());
        box2.add(new Apple());

        Box<Orange> box3 = new Box<>();
        box3.add(new Orange());
        box3.add(new Orange());
        box3.add(new Orange());
        box3.add(new Orange());
        box3.add(new Orange());
        box3.add(new Orange());

        Box<Orange> box4 = new Box<>();
        box4.add(new Orange());
        box4.add(new Orange());
        box4.add(new Orange());
        box4.add(new Orange());
        box4.add(new Orange());
        //Для хранения фруктов внутри коробки можно использовать ArrayList;
        System.out.println("Получаем список яблок");
        System.out.println(box1.getValue());
        //Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
        System.out.println("Получаем вес коробки");
        System.out.println(box1.getWeight());
        //Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
        System.out.println("Сравниваем вес коробок");
        System.out.println(box1.compare(box2));
        box2.add(new Apple());
        System.out.println(box1.compare(box2));
        //Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
        //очищаем коробку
        box1.getValue().clear();
        System.out.println("Коробка 1 перед заполнением яблоками: " + box1.getValue().size());
        System.out.println("Коробка 2 перед заполнением яблоками: " + box2.getValue().size());
        box2.fill(box1);
        System.out.println("Коробка 1 после пересыпания яблок из коробки 2: " + box1.getValue().size());
        System.out.println("Коробка 2 после пересыпания в коробку 1 яблок: " + box2.getValue().size());

        //Не забываем про метод добавления фрукта в коробку.

        box4.getValue().clear();
        System.out.println("Коробка 3 перед заполнением яблоками: " + box3.getValue().size());
        System.out.println("Коробка 4 перед заполнением яблоками: " + box4.getValue().size());
        box3.fill(box4);
        System.out.println("Коробка 3 после заполнения из коробки 4 апельсинами: " + box3.getValue().size());
        System.out.println("Коробка 4 после заполнения коробки 3 апельсинами: " + box4.getValue().size());

        System.out.println(new Apple() == new Apple());
        System.out.println(new Apple().equals(new Apple()));
    }

    public static <T> void swap(T[] params, int index1, int index2){
        if(params.length < (index1 + index2)/2 || (index1 + index2)/2 <= 0){
            return;
        }
        T buf = params[index1];
        params[index1] = params[index2];
        params[index2] = buf;
    }

    public static <T> ArrayList<T> arrayToArrayList(T[] elems){

        return new ArrayList<>(Arrays.asList(elems));
    }
}
