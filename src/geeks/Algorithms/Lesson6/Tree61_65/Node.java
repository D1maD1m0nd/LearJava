package geeks.Algorithms.Lesson6.Tree61_65;

public class Node {
    public Person person;
    public Node leftChild;
    public Node rightChild;
    public void display(){
        System.out.println("Name " + person.name + " Age " + person.age);
    }
}
