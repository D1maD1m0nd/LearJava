package geeks.Algorithms.Lesson4;

public class MyStackList {
    public static void main(String[] args) {
        StackList a = new StackList();

        a.push("ewq");
        a.push("ewqewq");
        a.push("ewqewqq");

        a.display();
        while (!a.isEmpty()){
            System.out.println(a.pop());
        }
    }
}
