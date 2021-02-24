package geeks.Lesson6;

public class Dog extends Animal {
    private static int count;

    Dog(String name) {
        super(name, 10, 500);
        count++;
    }

    public static int getCount() {
        return count;
    }
}
