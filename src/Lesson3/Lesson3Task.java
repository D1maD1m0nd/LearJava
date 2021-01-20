package Lesson3;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Lesson3Task {
    public static void main(String[] args) {
        //Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число. При каждой попытке компьютер должен сообщить,
        // больше ли указанное пользователем число, чем загаданное, или меньше.
        // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
        startGameGuessNumber(10);

    }
    public static int getRandomNum(int period){
        return new Random().nextInt(period);
    }
    public static int getUserAnswerGuessNum(int period){
        int usrNum;
        do{
            System.out.printf("Введите число от %d до %d или введите -1 для выхода: ", 0,period - 1);
            Scanner usr = new Scanner(System.in);
            usrNum = usr.nextInt();
            if(usrNum == -1) return -1;
        }while(usrNum > period || usrNum < 0 );
        System.out.println(usrNum);
        return usrNum;
    }
    public static int getUserAnswerContinueGame(){
        Scanner usr = new Scanner(System.in);
        int usrAnswer = usr.nextInt();
        if(usrAnswer == 1){
            return 0;
        }
        if(usrAnswer == 0){
            return -1;
        }
        return -1;

    }
    public static int checkLessMoreNum(int numUsr, int numHide){
        if(numUsr == numHide) {
            System.out.println("Вы победили ");
            return 0;
        }
        if(numUsr > numHide){
            System.out.println("Введенное число больше загаднного");
            return -1;
        }
        System.out.println("Введенное число меньше загаданного");
        return -1;
    }
    public static void startGameGuessNumber(int period){
        if(period < 0){
            System.out.println("период не может быть отрицательным значением");
            return;
        }
        int tryCount = 0;
        int result;
        boolean gameContinue = false;
        int guessNum = getRandomNum(period);
        do {
            tryCount++;

            int usrAnswer = getUserAnswerGuessNum(period);
            result = checkLessMoreNum(usrAnswer,guessNum);
            if(tryCount == 3 && result != 0){
                System.out.printf("К сожалению вы проиграли.\nЗагаданное число было %d если желаете поиграть снова," +
                        " то введите 1, в ином случае введите 0 ", guessNum);

                gameContinue = true;
            }
            if(result == 0){
                System.out.printf("Поздравляю вы справились за %d попыток, если желаете поиграть снова, то введите 1, в ином случае введите 0 ", tryCount);

                gameContinue = true;
            }

            if(gameContinue){
                if(getUserAnswerContinueGame() == -1){
                    System.out.println("Игра окончена!");
                    break;
                }
                guessNum = getRandomNum(period);
                tryCount = 0;
                gameContinue = false;
            }
        }while (true);

    }

}
