package geeks.Algorithms.Lesson6.Tree61_65;

public class App {
    public static void main(String[] args) {
        Tree theTree = new Tree();
        long t = System.nanoTime();
        long end;
        theTree.inset(new Person(1, "Ivan",15));
        end = System.nanoTime();
        System.out.println("Время вставки " + (end - t) + " ns");
        theTree.inset(new Person(2, "Ivan1",23));
        theTree.inset(new Person(3, "Ivan2",32));
        theTree.inset(new Person(4, "Ivan3",323));
        theTree.inset(new Person(5, "Ivan4",21));
        theTree.inset(new Person(6, "Ivan5",111));

        t = System.nanoTime();
        theTree.max().display();
        end = System.nanoTime();
        System.out.println("Поиск максимума " + (end - t) + " ns");

        t = System.nanoTime();
        theTree.min().display();
        end = System.nanoTime();
        System.out.println("Поиск минимума " + (end - t) + " ns");

        t = System.nanoTime();
        theTree.find(3);
        end = System.nanoTime();
        System.out.println("Поиск " + (end - t) + " ns");

        theTree.find(3).display();

        t = System.nanoTime();
        theTree.delete(2);
        end = System.nanoTime();
        System.out.println("Удаление " + (end - t) + " ns");

        System.out.println();
        t = System.nanoTime();
        theTree.displayTree();
        end = System.nanoTime();
        System.out.println("Печать " + (end - t) + " ns");
    }
}
