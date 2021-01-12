package com.company.Lesson1;

public class Task2 {

    public static void main(String[] args) {
        //2.Создать переменные всех пройденных типов данных и инициализировать их значения.
        byte b = 10;
        short s = 10;
        int i = 10;
        long l = 10L;
        float f = 10f;
        double d = 10;
        String str = "String";
        char ch = '1';
        boolean bool = true;
    /*
        3.Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    где a, b, c, d – аргументы этого метода, имеющие тип float.
    */

        System.out.println(calcExp(12f,13f,14f,15f));
        System.out.println(calcExp(12.32f,13.333f,14.321f,15.321321f));
/*
     4.   Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
     где a, b, c, d – аргументы этого метода, имеющие тип float.
*/

        System.out.println(checkIntervalNum(10));
        System.out.println(checkIntervalNum(20));
        System.out.println(checkIntervalNum(13));
        System.out.println(checkIntervalNum(30));
/*
       5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
       положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
*/

        printPositiveOrNegativeNum(5);
        printPositiveOrNegativeNum(0);
        printPositiveOrNegativeNum(-1);

/*
        6.Написать метод, которому в качестве параметра передается целое число.
        Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
 */
        System.out.println(checkNegativeNum(1));
        System.out.println(checkNegativeNum(0));
        System.out.println(checkNegativeNum(-1));

/*
        7.Написать метод, которому в качестве параметра передается строка,
     обозначающая имя. Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
 */
        printHelloName("Дима");
        printHelloName("Виолетта");
        printHelloName("Стас");
/*
        Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
        Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
*/
        calcLeapYear(14);
        calcLeapYear(18);
        calcLeapYear(100);
        calcLeapYear(96);
        calcLeapYear(32);
        calcLeapYear(400);
        calcLeapYear(1200);
        calcLeapYear(1100);
    }
    /**
     *Метод вычисляющий выражение вида a *(b + (c/d))
     * @return float результат выражения
    */
    static float calcExp(float a,float b,float c, float d){
        return a *(b + (c/d));
    }

    /**
     *Метод проверяющий выходит ли число в промежуток между 10 и 20
     * @param num целоечисло
     * @return boolean false/true
     */
    static  boolean checkIntervalNum(int num){
        return num <= 20 && num >= 10;
    }

    /**
     * Программа вычисляет положительное или отричательное число
     * @param num целове число
     * @return String возращает сообщение о том что число положительное или отрицательное
     *
     */
    static void printPositiveOrNegativeNum(int num){
        if(num >= 0) {
            System.out.println("Число положительное");
            return;
        }
        System.out.println("Число отрицательное");
    }
    /**
     * Программа вычисляет отрицательное число
     * @param num целове число
     * @return String возращает true, если число отрицательное
     *
     */
    static boolean checkNegativeNum(int num){
        return num < 0;
    }

    /**
     *Выводит приветствие определенного человека
     * @param name имя которое необходимо напечатать
     * @return печатает имя в консоли
     */
    static  void printHelloName(String name){
        System.out.println("Привет " + name);
    }

    /**
     * Вычисляет високосный год
     * @param year год
     */
    static void calcLeapYear(int year){
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            System.out.println(year + " год високосный");
            return;
        }
        System.out.println(year + " год не високосный");
    }
}
