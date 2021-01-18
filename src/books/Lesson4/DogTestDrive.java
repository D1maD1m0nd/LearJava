package books.Lesson4;

public class DogTestDrive {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.setSize(123);
        d.bark(3);
        DogTestDrive dog = new DogTestDrive();
        System.out.println(dog.go()
        );
    }

    int go(){
        return 1*43;
    }
}
