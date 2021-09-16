package Achitecture.Lesson4;



public class App {
    public static void main(String[] args) {
         Numbers numbers = new Numbers();
         TableNumber tableNumber = new TableNumber();

         ControlNumber c1 = new ControlNumber(numbers);
         ControlNumber c2 = new ControlNumber(tableNumber);

        for (int i = 0; i < 10000; i++) {
            c1.addNumber(5);
            c2.addNumber(51111);
        }

        System.out.println(c1.sumNumbers());
        System.out.println(c2.sumNumbers());
    }
}
