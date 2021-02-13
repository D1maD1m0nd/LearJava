package geeks.Lesson9.HW;

public class MyArrayDataException extends Exception{
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    MyArrayDataException(String address){
        super(ANSI_RED + "ОШИБКА: В ячейке по адресу " + address  + ANSI_RESET);
    }
}
