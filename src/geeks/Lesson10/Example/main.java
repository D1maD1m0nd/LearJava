package geeks.Lesson10.Example;

import java.util.*;

public class main {
    public static void main(String[] args) {
        Cats cats = new Cats(4);
        cats.add(new Cat("Danya",14));
        cats.add(new Cat("Vanya",14));
        cats.add(new Cat("Anya",14));
        cats.add(new Cat("Ganya",14));
        cats.add(new Cat("Danya",14));
        cats.add(new Cat("Vanya",14));
        cats.add(new Cat("Anya",14));
        cats.add(new Cat("Ganya",14));

        System.out.println(cats.getLength());
        System.out.println("Список");

        //массив, но при каждом добавлении выходящим за его индекс создает новый массив
        List catsList = new ArrayList();

        //хранит коллекцию не повторяющихся объектов
        Set catsSet = new HashSet();
        catsSet.add(new Cat("Danya",14));
        catsSet.add(new Cat("Ganya",14));
        catsSet.add(new Cat("Danya",14));
        System.out.println(catsSet);

        Map catsMap = new HashMap();


    }
}
