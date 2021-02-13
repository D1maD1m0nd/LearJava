package geeks.Lesson9.HW;

public class MyArraySizeException extends Exception{

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    MyArraySizeException(){
        super( ANSI_RED + "Был передан массив недопустимного размера" + ANSI_RESET);
    };


}
