package geeks.Lesson9.HW;

public class MyArraySizeException extends Exception {


    MyArraySizeException() {
        super(Main.ANSI_RED + "ОШИБКА:Был передан массив недопустимного размера" + Main.ANSI_RESET);
    }

    ;


}
