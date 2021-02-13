package geeks.Lesson9.HW;

public class MyArraySizeException extends Exception{

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    MyArraySizeException(){
        super( ANSI_RED + "Массив превышает допустимое значение размерности массива" + ANSI_RESET);
    };


}
