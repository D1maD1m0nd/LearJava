package books.headfirst.Lesson7.HW;

public class TestBoats {
    public static void main(String[] args){
        Boat b1 = new Boat();
        Sailboat b2 = new Sailboat();
        Rowboat b3 = new Rowboat();

        b1.move();
        b3.move();

        b2.move();
    }
}
