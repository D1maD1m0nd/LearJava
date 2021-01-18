package books.Lesson3;

public class testDog {
    public static void main(String[] args) {
        Dog[] dogs;
        dogs = new Dog[6];
        dogs[0] = new Dog();
        dogs[1] = new Dog();
        dogs[3] = dogs[1];
        System.out.println(dogs[0] + " " + dogs[1] + " " + dogs[5]);
    }
}
