package Lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TikTakToe {
    public static char[][] map;
    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    //массивы для направлений
    //Дагонали, дорого по памяти, но я не смог вывести более оптимальную формулу
    public static final int[][][] ARR_DIAG = new int[SIZE * SIZE * 2][DOTS_TO_WIN][2];
    //Вертикаль
    public static final int[][][] ARR_VERTICAL = new int[SIZE * SIZE * 2][DOTS_TO_WIN][2];
    //Горизонталь
    public static final int[][] ARR_HORIZONTAL = new int[SIZE * SIZE * 2][DOTS_TO_WIN];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Собираем коордианты всех диагональных значений
        collectingMainDiagonalSequences();
        //Собираем координаты всех  вертикальных
        collectingVerticalSequences();
        //Собираем координаты всех горизонтальных
        collectingHorizontalSequences();
        initMap();
        printMap();
        boolean humanWin;
        boolean aiWin = false;
        do {
            humanTurn();
            printMap();
            humanWin = checkWin(DOT_X);

            if (humanWin) {
                break;
            }
            aiTurn();
            printMap();
            aiWin = checkWin(DOT_O);

            if (aiWin || mapIsFull()) {
                break;
            }
        } while (true);
        if (humanWin) {
            System.out.println("Победил человек");
        }
        if (aiWin) {
            System.out.println("Победил компьютер");
        }
        if (!humanWin && !aiWin) {
            System.out.println("Ничья");
        }
    }

    private static boolean checkWin(char symbol) {
        //        //что в строке есть нужное количество символов подряд
        for(char[] row : map){
            for (int i = 0; i < SIZE; i++) {
                if(row[i] == symbol){
                    for (int[]ints: ARR_HORIZONTAL) {
                        //это баг из-за размерности массива
                        if(ints[1] == 0 && ints[0] == 0 ){
                            break;
                        }
                        int countQuanity = 0;

                        for (int index : ints) {
                            if(row[index] == symbol){
                                countQuanity++;
                            }
                            else{
                                break;
                            }
                            if(countQuanity == DOTS_TO_WIN){
                                return true;
                            }
                        }


                    }
                }
            }
        }


            for (int[][] intsArr1:ARR_VERTICAL) {
                //это баг из-за размерности массива
                if(intsArr1[1][0] == 0 && intsArr1[1][1] == 0){
                    break;
                }
                int countQuanity = 0;
                for (int[] intsArr2 : intsArr1) {

                   int row = intsArr2[0];
                   int column = intsArr2[1];
                   if(map[row][column] == symbol){
                       countQuanity++;
                   }else{
                       break;
                   }
                   if(countQuanity == DOTS_TO_WIN){
                       return true;
                   }
                }
            }
        for (int[][] intsArr1:ARR_DIAG) {
            //это баг из-за размерности массива
            if(intsArr1[1][0] == 0 && intsArr1[1][1] == 0){
                break;
            }
            int countQuanity = 0;
            for (int[] intsArr2 : intsArr1) {

                int row = intsArr2[0];
                int column = intsArr2[1];
                if(map[row][column] == symbol){
                    countQuanity++;
                }else{
                    break;
                }
                if(countQuanity == DOTS_TO_WIN){
                    return true;
                }
            }
        }
        return false;
    }
    public static void collectingVerticalSequences(){
        int start, end, row = 0;
        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {
                start = j;
                end = SIZE - 1 - j;
                if(j + DOTS_TO_WIN > SIZE){
                    break;
                }
                for (int k = 0; k < DOTS_TO_WIN; k++) {
                    ARR_VERTICAL[row][k][0] = start;
                    ARR_VERTICAL[row][k][1] = i;
                    start++;

                }
                row++;
                for (int k = 0; k < DOTS_TO_WIN; k++) {
                    ARR_VERTICAL[row][k][0] = end;
                    ARR_VERTICAL[row][k][1] = i;
                    end--;

                }
                row++;
            }


        }
    }
    public  static void collectingHorizontalSequences(){
        int start, end, row = 0;
        for (int i = 0; i < SIZE; i++) {
            start = i;
            end = SIZE - 1 - i;
            if(start + DOTS_TO_WIN > SIZE){
                break;
            }
            for (int j = 0; j < DOTS_TO_WIN; j++) {
                ARR_HORIZONTAL[row][j] = start;

                start++;
            }
            row++;
            System.out.print("   ");
            for (int j = 0; j < DOTS_TO_WIN; j++) {
                ARR_HORIZONTAL[row][j] = end;
                end--;
            }
            row++;
            System.out.println();
        }
    }
    public static void collectingMainDiagonalSequences(){
        int start, end, rows = 0;
        for (int l = 0; l < SIZE; l++) {
            if(DOTS_TO_WIN + l > SIZE){
                break;
            }
            for (int k = 0; k < SIZE; k++) {

                start = l;
                end = SIZE - 1 - l;
                if(DOTS_TO_WIN + k > SIZE){
                    break;
                }
                for (int i = 0; i < DOTS_TO_WIN; i++) {
                    ARR_DIAG[rows][i][0] = start;
                    ARR_DIAG[rows][i][1] = i+k;
                    start++;
                }
                rows++;
                for (int i = 0; i < DOTS_TO_WIN; i++) {
                    ARR_DIAG[rows][i][0] = i+k;
                    ARR_DIAG[rows][i][1] = end;
                    end--;
                }
                rows++;
            }
        }
    }
    private static boolean mapIsFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void aiTurn() {

        int x, y;
        do {
            x = new Random().nextInt(SIZE);
            y = new Random().nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[x][y] = DOT_O;
    }

    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите коордаты");
            System.out.println("Введите X");
            x = scanner.nextInt() - 1;
            System.out.println("Введите Y");
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = DOT_X;
    }

    private static boolean isCellValid(int x, int y) {//true если условие валидно, т.е. мы можем поставить символ в эту ячейку, false в иных случаях
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE && map[x][y] == DOT_EMPTY;
    }

    private static void printMap() {
        for (int i = 0; i < SIZE; i++) {
            System.out.println();
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
        }
        System.out.println();
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (char[] row : map) {
            Arrays.fill(row, DOT_EMPTY);
        }
    }
}
