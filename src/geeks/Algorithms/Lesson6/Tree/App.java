package geeks.Algorithms.Lesson6.Tree;

public class App {
    public static void main(String[] args) {
        Tree theTree = new Tree();

        theTree.inset(new Person(1, "Ivan",15));
        theTree.inset(new Person(2, "Ivan1",23));
        theTree.inset(new Person(3, "Ivan2",32));
        theTree.inset(new Person(4, "Ivan3",323));
        theTree.inset(new Person(5, "Ivan4",21));
        theTree.inset(new Person(6, "Ivan5",111));

        theTree.max().display();
        theTree.min().display();

        theTree.find(3).display();

        theTree.delete(2);
        System.out.println();
        theTree.displayTree();
    }
}
