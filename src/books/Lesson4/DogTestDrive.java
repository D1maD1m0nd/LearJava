package books.Lesson4;

public class DogTestDrive {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.name = "Kate";
        d.size = 12;
        d.bark(3);
        Dog d1 = new Dog();
        d1.size = 1;
        d1.name = "Markus";
        d1.bark(2);


    }
}
