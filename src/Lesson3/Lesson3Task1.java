package Lesson3;


import java.util.Random;
import java.util.Scanner;

public class Lesson3Task1 {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        //Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число. При каждой попытке компьютер должен сообщить,
        // больше ли указанное пользователем число, чем загаданное, или меньше.
        // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).


        startGameGuessNumber(9);

    }

    /**
     * @param period максимальное значение до которого необходимо сгенерировать число
     * @return возвращает число из заданногов параметре диапазона
     */
    public static int getRandomNum(int period) {

        return new Random().nextInt(period + 1);
    }

    /**
     * @param period число больше которого нельзя ввести значение действует как ограничитель
     * @return введенное число пользователем в заданном диапазоне
     */
    public static int getUserAnswerGuessNum(int period) {
        int usrNum;

        do {
            System.out.printf("Введите число от %d до %d или введите -1 для выхода: ", 0, period);

            usrNum = SCANNER.nextInt();
            if (usrNum == -1) return -1;
        } while (usrNum > period || usrNum < 0);
        System.out.println(usrNum);
        return usrNum;
    }

    /**
     * @return возвращает тру в случае, если пользователь ввел 1 для продолжения игры
     */
    public static boolean getUserAnswerContinueGame() {
        Scanner usr = new Scanner(System.in);
        int usrAnswer = usr.nextInt();
        return usrAnswer == 1;

    }

    /**
     * Проверка результата введенного числа
     *
     * @param numUsr  число пользователя
     * @param numHide загаданное число
     * @return возвращает true в случае если два параметра равны
     */
    public static boolean checkLessMoreNum(int numUsr, int numHide) {
        if (numUsr == numHide) {
            System.out.println("Вы победили ");
            return true;
        }
        if (numUsr > numHide) {
            System.out.println("Введенное число больше загаднного");
            return false;
        }
        System.out.println("Введенное число меньше загаданного");
        return false;
    }

    /**
     * начало игры
     *
     * @param period максимально возможное число
     */
    public static void startGameGuessNumber(int period) {
        if (period < 0) {
            System.out.println("период не может быть отрицательным значением");
            return;
        }
        /*
        @tryCount - счетчик попыток
        @result - переменная показывающая победил игрок или нет
        @gameContinue - флаг продолжения игры
        @guessNum переменная для хранения случайного числа
         */
        int tryCount = 0;
        boolean result;
        boolean gameContinue = false;
        int guessNum = getRandomNum(period);
        do {
            tryCount++;

            int usrAnswer = getUserAnswerGuessNum(period);
            result = checkLessMoreNum(usrAnswer, guessNum);
            if (tryCount == 3 && !result) {
                System.out.printf("К сожалению вы проиграли.\nЗагаданное число было %d если желаете поиграть снова," +
                        " то введите 1, в ином случае введите любой символ отличный от 1  ", guessNum);

                gameContinue = true;
            }
            if (result) {
                System.out.printf("Поздравляю вы справились за %d попыток, если желаете поиграть снова, то введите 1, в ином случае введите любой символ отличный от 1 ", tryCount);

                gameContinue = true;
            }

            if (gameContinue) {
                if (!getUserAnswerContinueGame()) {
                    System.out.println("Игра окончена!");
                    break;
                }
                guessNum = getRandomNum(period);
                tryCount = 0;
                gameContinue = false;
            }
        } while (true);

    }

}
