package geeks.Lesson9.HW;

public class MyArrayDataException extends Exception{
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    MyArrayDataException(String address, String value){
        super(ANSI_RED + "В ячейке по адресу " + address + " не удалось привести значение " + value + " к числу" + ANSI_RESET);
    }
}
