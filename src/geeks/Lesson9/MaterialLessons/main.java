package geeks.Lesson9.MaterialLessons;

import java.nio.channels.AcceptPendingException;

public class main {
    public static void main(String[] args) {
        try {
            System.out.println(someFunction(5,1));
            System.out.println(someFunction(5,1));
            System.out.println(someFunction(5,2));
            System.out.println(someFunction(5,3));
            System.out.println(someFunction(1.0,0.0));
            System.out.println(someFunction(5,0));

        }
        catch(ArithmeticException e){
            System.out.println("Необъявляемое исключение");
        }

        catch (MyZeroExeption e){
            System.out.println(e.getMessage());
        }
        System.out.println(someFunction(5.0,0.0));

    }
    public static int  someFunction(int a, int b) throws MyZeroExeption{
        if(a == 0 || b == 0){
            throw new MyZeroExeption();
        }
        return a/b;
    }
    public static double  someFunction(double a, double b){
        return a/b;
    }
}
