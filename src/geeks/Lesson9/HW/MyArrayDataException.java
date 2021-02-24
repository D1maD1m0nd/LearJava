package geeks.Lesson9.HW;

public class MyArrayDataException extends Exception {

    MyArrayDataException(String address) {
        super(Main.ANSI_RED + "ОШИБКА: В ячейке по адресу " + address + Main.ANSI_RESET);
    }
}
