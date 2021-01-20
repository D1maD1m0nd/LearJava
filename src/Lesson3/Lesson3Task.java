package Lesson3;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Lesson3Task {
    public static void main(String[] args) {
        //Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число. При каждой попытке компьютер должен сообщить,
        // больше ли указанное пользователем число, чем загаданное, или меньше.
        // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).


    }
    public static int getRandomNum(int period){
        return new Random().nextInt(period);
    }
    public static int getUserAnswerGuessNum(int period){
        int usrNum;
        do{
            System.out.printf("Введите число от %d до %d или введите -1 для выхода: ", 0,period);
            Scanner usr = new Scanner(System.in);
            usrNum = usr.nextInt();
            if(usrNum == -1) return -1;
        }while(usrNum > period || usrNum < 0 );
        System.out.println(usrNum);
        return usrNum;
    }
    public static int getUserAnswerContinueGame(){
        Scanner usr = new Scanner(System.in);
        String usrAnswer = usr.next();
        if(usrAnswer.toLowerCase(Locale.ROOT) == "да"){
            return 0;
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
        int guessNum = getRandomNum(period);
        do {
            tryCount++;
            int usrAnswer = getUserAnswerGuessNum(period);
            result = (checkLessMoreNum(usrAnswer,guessNum) == 0) ? 0 : -1 ;
            if(result == 0){
                System.out.printf("Поздравляю вы справились за %d попыток, если желаете поиграть снова, то введите ДА, в ином случае введите НЕТ или любые символы", tryCount);
            }
            if(tryCount == 3){
                System.out.println("К сожалению вы проиграли, если желаете поиграть снова, то введите ДА, в ином случае введите НЕТ или любые символы");
            }
        }while (true);

    }

}
