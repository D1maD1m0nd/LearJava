package books.headfirst.Lesson2;

public class Player {
    int number = 0;

    public void guess() {
        number = (int) (Math.random() * 10000000);
        System.out.println("Think it" + number);
    }
}
