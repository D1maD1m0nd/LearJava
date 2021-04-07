package books.headfirst.Lesson8;

public class Dog extends Animal implements Pet{

    @Override
    public void beFriendly() {
        System.out.println("Mur mur mur");
    }

    @Override
    public void play() {
        System.out.println("Game game game");
    }
}
