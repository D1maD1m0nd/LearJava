package Lesson3;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Task {
    public static void main(String[] args) {
        //Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число. При каждой попытке компьютер должен сообщить,
        // больше ли указанное пользователем число, чем загаданное, или меньше.
        // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).


    }
    public static int getRandomNum(int period){
        if(period < 0){
            System.out.println("конец периода не может быть отрицательным значением");
            return -1;
        }
        return new Random().nextInt(period);
    }
    public static int getUserAnswers(int period){
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

}
