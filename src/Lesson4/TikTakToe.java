package Lesson4;

import java.util.Arrays;
import java.util.Scanner;

public class TikTakToe {
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;



    //переменная для хранения текущего хода
    public static int currrentTurn = 0;
    //массивы для направлений
    //Дагонали
    public static int lenArrDiag = collectingMainDiagonalSequences(false);
    public static final int[][][] ARR_DIAG = new int[lenArrDiag][DOTS_TO_WIN][2];
    //Вертикаль
    public static int lenArrVertical = collectingVerticalSequences(false);
    public static final int[][][] ARR_VERTICAL = new int[lenArrVertical][DOTS_TO_WIN][2];
    //Горизонталь
    public static int lenArrHorizontal = collectingHorizontalSequences(false);
    public static final int[][] ARR_HORIZONTAL = new int[lenArrHorizontal][DOTS_TO_WIN];
    public static Scanner scanner = new Scanner(System.in);

    //предыдущая колонка
    public static int prevAiColumn = 0;
    //текущая строка
    public static int prevAiRow = 0;

    //состояние центральной точки
    public static boolean middleState = false;

    public static void main(String[] args) {
        //Собираем коордианты всех диагональных значений
        collectingMainDiagonalSequences(true);
        //Собираем координаты всех  вертикальных
        collectingVerticalSequences(true);
        //Собираем координаты всех горизонтальных
        collectingHorizontalSequences(true);
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
            currrentTurn++;
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

    /**
     * Проверка победы
     *
     * @param symbol проверяемый символ
     * @return true в случае победы одного из игроков
     */
    private static boolean checkWin(char symbol) {
        //Если текущий ход не равен количеству точек для победы, то возвращает false
        if(currrentTurn  < DOTS_TO_WIN - 1){
            return false;
        }
        //что в строке есть нужное количество символов подряд
        for (char[] row : map) {
            for (int i = 0; i < SIZE; i++) {
                if (row[i] == symbol) {
                    for (int[] ints : ARR_HORIZONTAL) {

                        int countQuanity = 0;

                        for (int index : ints) {
                            if (row[index] == symbol) {
                                countQuanity++;
                            } else {
                                break;
                            }
                            if (countQuanity == DOTS_TO_WIN) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        //вертикаль
        for (int[][] intsArr1 : ARR_VERTICAL) {

            int countQuanity = 0;
            for (int[] intsArr2 : intsArr1) {

                int row = intsArr2[0];
                int column = intsArr2[1];
                if (map[row][column] == symbol) {
                    countQuanity++;
                } else {
                    break;
                }
                if (countQuanity == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        //диагональ
        for (int[][] intsArr1 : ARR_DIAG) {

            int countQuanity = 0;
            for (int[] intsArr2 : intsArr1) {

                int row = intsArr2[0];
                int column = intsArr2[1];
                if (map[row][column] == symbol) {
                    countQuanity++;
                } else {
                    break;
                }
                if (countQuanity == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Метод записывает в массив вертикальную последовательность
     *
     * @param writeMode мод для записи в массив, в случае false , метод считает количество записей
     * @return возвращает количество записей
     */
    public static int collectingVerticalSequences(boolean writeMode) {
        int start, end, row = 0;
        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {
                start = j;
                end = SIZE - 1 - j;
                if (j + DOTS_TO_WIN > SIZE) {
                    break;
                }
                for (int k = 0; k < DOTS_TO_WIN; k++) {
                    if (writeMode) {
                        ARR_VERTICAL[row][k][0] = start;
                        ARR_VERTICAL[row][k][1] = i;
                    }

                    start++;

                }
                row++;
                for (int k = 0; k < DOTS_TO_WIN; k++) {
                    if (writeMode) {
                        ARR_VERTICAL[row][k][0] = end;
                        ARR_VERTICAL[row][k][1] = i;
                    }

                    end--;

                }
                row++;
            }
        }
        return row;
    }

    /**
     * Метод записывает в массив горизонатльную последовательность
     *
     * @param writeMode мод для записи в массив, в случае false , метод считает количество записей
     * @return возвращает количество записей
     */
    public static int collectingHorizontalSequences(boolean writeMode) {
        int start, end, row = 0;
        for (int i = 0; i < SIZE; i++) {
            start = i;
            end = SIZE - 1 - i;
            if (start + DOTS_TO_WIN > SIZE) {
                break;
            }
            for (int j = 0; j < DOTS_TO_WIN; j++) {
                if (writeMode) {
                    ARR_HORIZONTAL[row][j] = start;
                }


                start++;
            }
            row++;
            for (int j = 0; j < DOTS_TO_WIN; j++) {
                if (writeMode) {
                    ARR_HORIZONTAL[row][j] = end;
                }
                end--;
            }
            row++;

        }
        return row;
    }

    /**
     * Метод записывает в массив диагональную последовательность
     *
     * @param writeMode мод для записи в массив, в случае false , метод считает количество записей
     * @return возвращает количество записей
     */
    public static int collectingMainDiagonalSequences(boolean writeMode) {
        int start, end, rows = 0;
        for (int l = 0; l < SIZE; l++) {
            if (DOTS_TO_WIN + l > SIZE) {
                break;
            }
            for (int k = 0; k < SIZE; k++) {

                start = l;
                end = SIZE - 1 - l;
                if (DOTS_TO_WIN + k > SIZE) {
                    break;
                }
                for (int i = 0; i < DOTS_TO_WIN; i++) {
                    if (writeMode) {
                        ARR_DIAG[rows][i][0] = start;
                        ARR_DIAG[rows][i][1] = i + k;
                    }

                    start++;
                }
                rows++;
                for (int i = 0; i < DOTS_TO_WIN; i++) {
                    if (writeMode) {
                        ARR_DIAG[rows][i][0] = i + k;
                        ARR_DIAG[rows][i][1] = end;
                    }

                    end--;
                }
                rows++;
            }
        }
        return rows;
    }

    /**
     * Проверка на заполненность карты
     *
     * @return возвращает true в случае ее заполненности
     */
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

    /**
     * Блокирует вертикальную последовательность
     *
     * @param point количество элемент от которого необходимо произвести блок
     * @return возвращает true в случае блокирования хода аппонента
     */
    private static boolean aiVertical(int point) {
        //Вертикальное блокирование
        for (int[][] intsArr1 : ARR_VERTICAL) {
            if (map[intsArr1[0][0]][intsArr1[0][1]] == DOT_O || map[intsArr1[DOTS_TO_WIN - 1][0]][intsArr1[DOTS_TO_WIN - 1][1]] == DOT_O) {
                continue;
            }
            int dotColumn = 0;
            int dotRow = 0;
            int countStep = 0;
            int countQuanity = 0;
            for (int[] intsArr2 : intsArr1) {
                countStep++;
                int row = intsArr2[0];
                int column = intsArr2[1];

                if (map[row][column] == DOT_X && countQuanity != DOTS_TO_WIN - point) {
                    countQuanity++;
                } else if(map[row][column] == DOT_EMPTY){
                    dotRow = row;
                    dotColumn = column;
                }
                if (countQuanity == DOTS_TO_WIN - point && countStep == DOTS_TO_WIN) {
                    map[dotRow][dotColumn] = DOT_O;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Блокирует горизонтальную последовательность
     *
     * @param point количество элемент от которого необходимо произвести блок
     * @return возвращает true в случае блокирования хода аппонента
     */
    private static boolean aiHorizontal(int point) {

        int rows = 0;
        //что в строке есть нужное количество символов подряд
        for (char[] row : map) {

            for (int i = 0; i < SIZE; i++) {
                int dotColumn = 0;
                int countStep = 0;
                for (int[] ints : ARR_HORIZONTAL) {

                    //проверка на заполненность перебираемого значения
                    if(row[ints[0]] == DOT_O || row[ints[DOTS_TO_WIN - 1]] == DOT_O){
                        break;
                    }
                    int countQuanity = 0;
                    for (int index : ints) {
                        countStep++;
                        if (row[index] == DOT_X && countQuanity != DOTS_TO_WIN - point) {
                            countQuanity++;
                        }else if(row[index] == DOT_EMPTY){
                            dotColumn = index;
                        }
                        if (countQuanity == DOTS_TO_WIN - point && countStep == DOTS_TO_WIN) {

                            map[rows][dotColumn] = DOT_O;
                            return true;
                        }
                    }

                }
            }
            rows++;
        }
        return false;
    }

    /**
     * Блокирует диагональную последовательность
     *
     * @param point количество элемент от которого необходимо произвести блок
     * @return возвращает true в случае блокирования хода аппонента
     */
    private static boolean aiDiag(int point) {
        for (int[][] intsArr1 : ARR_DIAG) {
            if (map[intsArr1[0][0]][intsArr1[0][1]] == DOT_O || map[intsArr1[DOTS_TO_WIN - 1][0]][intsArr1[DOTS_TO_WIN - 1][1]] == DOT_O) {
                continue;
            }
            int dotColumn = 0;
            int dotRow = 0;
            int sideDiag = 0;
            int mainDiag = 0;
            int countQuanity = 0;
            int countStep = 0;
            for (int[] intsArr2 : intsArr1) {
                countStep++;
                int row = intsArr2[0];
                int column = intsArr2[1];
                if (row == column) {
                    mainDiag++;
                } else {
                    sideDiag++;
                }
                if (map[row][column] == DOT_X && countQuanity != DOTS_TO_WIN - point) {
                    countQuanity++;
                } else if (map[row][column] == DOT_EMPTY) {
                    dotRow = row;
                    dotColumn = column;
                }
                if (countQuanity == DOTS_TO_WIN - point && countStep == DOTS_TO_WIN) {

                    if (mainDiag >= DOTS_TO_WIN - 1) {
                        map[dotRow][dotColumn] = DOT_O;
                        return true;
                    }
                    if (sideDiag >= DOTS_TO_WIN - 1) {
                        map[dotRow][dotColumn] = DOT_O;
                        return true;
                    }

                }
            }
        }
        return false;
    }

    /**
     * Проеряет горизонтальную  последовательность на предмет победы
     *
     * @param point количество элемент от которого необходимо произвести блок
     * @return возвращает true в случае блокирования хода аппонента
     */
    private static boolean aiHorizontalWin(int point) {

        int rows = 0;
        //что в строке есть нужное количество символов подряд
        for (char[] row : map) {

            for (int i = 0; i < SIZE; i++) {
                int dotColumn = 0;
                int countStep = 0;
                for (int[] ints : ARR_HORIZONTAL) {

                    //проверка на заполненность перебираемого значения
                    if (row[ints[0]] == DOT_X || row[ints[DOTS_TO_WIN - 1]] == DOT_X) {
                        break;
                    }
                    int countQuanity = 0;
                    for (int index : ints) {
                        countStep++;
                        if (row[index] == DOT_O && countQuanity != DOTS_TO_WIN - point) {
                            countQuanity++;
                        } else if (row[index] == DOT_EMPTY) {
                            dotColumn = index;
                        }
                        if (countQuanity == DOTS_TO_WIN - point && countStep == DOTS_TO_WIN) {

                            map[rows][dotColumn] = DOT_O;
                            return true;
                        }
                    }

                }
            }
            rows++;
        }
        return false;
    }

    /**
     * Проеряет диагональную  последовательность на предмет победы
     *
     * @param point количество элемент от которого необходимо произвести блок
     * @return возвращает true в случае блокирования хода аппонента
     */
    private static boolean aiDiagWin(int point) {
        for (int[][] intsArr1 : ARR_DIAG) {
            if (map[intsArr1[0][0]][intsArr1[0][1]] == DOT_X || map[intsArr1[DOTS_TO_WIN - 1][0]][intsArr1[DOTS_TO_WIN - 1][1]] == DOT_X) {
                continue;
            }
            int dotColumn = 0;
            int dotRow = 0;
            int sideDiag = 0;
            int mainDiag = 0;
            int countQuanity = 0;
            int countStep = 0;
            for (int[] intsArr2 : intsArr1) {
                countStep++;
                int row = intsArr2[0];
                int column = intsArr2[1];
                if (row == column) {
                    mainDiag++;
                } else {
                    sideDiag++;
                }
                if (map[row][column] == DOT_O && countQuanity != DOTS_TO_WIN - point) {
                    countQuanity++;
                } else if (map[row][column] == DOT_EMPTY) {
                    dotRow = row;
                    dotColumn = column;
                }
                if (countQuanity == DOTS_TO_WIN - point && countStep == DOTS_TO_WIN) {

                    if (mainDiag >= DOTS_TO_WIN - 1) {
                        map[dotRow][dotColumn] = DOT_O;
                        return true;
                    }
                    if (sideDiag >= DOTS_TO_WIN - 1) {
                        map[dotRow][dotColumn] = DOT_O;
                        return true;
                    }

                }
            }
        }
        return false;
    }

    /**
     * Проеряет вертикальную  последовательность на предмет победы
     *
     * @param point количество элемент от которого необходимо произвести блок
     * @return возвращает true в случае блокирования хода аппонента
     */
    private static boolean aiVerticalWin(int point) {
        //Вертикальное блокирование
        for (int[][] intsArr1 : ARR_VERTICAL) {
            if (map[intsArr1[0][0]][intsArr1[0][1]] == DOT_X || map[intsArr1[DOTS_TO_WIN - 1][0]][intsArr1[DOTS_TO_WIN - 1][1]] == DOT_X) {
                continue;
            }
            int dotColumn = 0;
            int dotRow = 0;
            int countStep = 0;
            int countQuanity = 0;
            for (int[] intsArr2 : intsArr1) {
                countStep++;
                int row = intsArr2[0];
                int column = intsArr2[1];

                if (map[row][column] == DOT_O && countQuanity != DOTS_TO_WIN - point) {
                    countQuanity++;
                } else if(map[row][column] == DOT_EMPTY){
                    dotRow = row;
                    dotColumn = column;
                }
                if (countQuanity == DOTS_TO_WIN - point && countStep == DOTS_TO_WIN) {
                    map[dotRow][dotColumn] = DOT_O;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Ищет горизонтальную  последовательность по координатам предыдущей точки или ищет совершенно новую последовательность
     *
     * @param searchNewReq состояние поиска новой последоватеьности
     * @return возвращает true в случае блокирования хода аппонента
     */
    private static boolean aiHorizontalSearch(boolean searchNewReq) {

        int rows = 0;
        //что в строке есть нужное количество символов подряд
        for (char[] row : map) {

            for (int i = 0; i < SIZE; i++) {
                for (int[] ints : ARR_HORIZONTAL) {

                    //проверка на заполненность перебираемого значения
                    if(row[ints[0]] == DOT_X || row[ints[DOTS_TO_WIN - 1]] == DOT_X){
                        break;
                    }
                    for (int index : ints) {
                        if(prevAiColumn == index && prevAiRow == rows){
                            if(row[index] == DOT_EMPTY){
                                map[prevAiRow][index] = DOT_O;
                                return true;
                            }
                        }else if(searchNewReq && row[index] == DOT_EMPTY){
                            map[rows][index] = DOT_O;
                            prevAiRow = rows;
                            prevAiColumn = index;
                            return true;
                        }

                    }

                }
            }
            rows++;
        }
        return false;
    }

    /**
     * Ищет вертикальную  последовательность по координатам предыдущей точки или ищет совершенно новую последовательность
     *
     * @param searchNewReq состояние поиска новой последоватеьности
     * @return возвращает true в случае блокирования хода аппонента
     */
    private static boolean aiVerticalSearch(boolean searchNewReq) {
        //Вертикальное блокирование
        for (int[][] intsArr1 : ARR_VERTICAL) {
            if (map[intsArr1[0][0]][intsArr1[0][1]] == DOT_X || map[intsArr1[DOTS_TO_WIN - 1][0]][intsArr1[DOTS_TO_WIN - 1][1]] == DOT_X) {
                continue;
            }
            for (int[] intsArr2 : intsArr1) {

                int row = intsArr2[0];
                int column = intsArr2[1];
                if(row == prevAiRow && column == prevAiRow){
                    if(map[row][column] == DOT_EMPTY){
                        map[row][column] = DOT_O;
                        return true;
                    }
                } else if (searchNewReq && map[row][column] == DOT_EMPTY) {
                    map[row][column] = DOT_O;
                    prevAiRow = row;
                    prevAiColumn = column;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Ищет диагональную  последовательность по координатам предыдущей точки или ищет совершенно новую последовательность
     *
     * @param searchNewReq состояние поиска новой последоватеьности
     * @return возвращает true в случае блокирования хода аппонента
     */
    private static boolean aiDiagSearch(boolean searchNewReq) {
        for (int[][] intsArr1 : ARR_DIAG) {
            if (map[intsArr1[0][0]][intsArr1[0][1]] == DOT_X || map[intsArr1[DOTS_TO_WIN - 1][0]][intsArr1[DOTS_TO_WIN - 1][1]] == DOT_X) {
                continue;
            }

            for (int[] intsArr2 : intsArr1) {
                int row = intsArr2[0];
                int column = intsArr2[1];
                if (row == prevAiRow && column == prevAiColumn){
                    if(map[row][column] == DOT_EMPTY){
                        map[row][column] = DOT_O;
                        return true;
                    }else if(searchNewReq && map[row][column] == DOT_EMPTY){
                        map[row][column] = DOT_O;
                        prevAiRow = row;
                        prevAiColumn = column;
                        return true;
                    }
                }

            }
        }
        return false;
    }
    private static void aiTurn() {
            //Минимальное число последовательности для блокировки с округление в больную сторону
            int minTurn = DOTS_TO_WIN/2;
            int maxTurn = 1;
            //считаем индекс центра
            int middleColumn = SIZE/2;
            int startIndex = 0;

            int countO = 0;
            //состояния проверки
            boolean stateH = false;
            boolean stateV = false;
            boolean stateD = false;



            //Ищем выигрышную последовательность
            //Вычисляем ход. после которого необходимо вести проверку на выигрышную последовательность у крестиков или ноликов
          if(DOTS_TO_WIN - minTurn - 1 <= currrentTurn){
              //Ищем выигрышную последовательность
              if(aiHorizontalWin(maxTurn) || aiVerticalWin(maxTurn) || aiDiagWin(maxTurn)){
                  return;
              }


              stateH = aiHorizontal(maxTurn);
              stateD = aiDiag(maxTurn);
              stateV  = aiVertical(maxTurn);
              if(stateH || stateD || stateV) {
                  return;
              }
              if(!(stateH && stateD && stateV) && minTurn != maxTurn){
                  stateH = aiHorizontal(minTurn);
                  stateD = aiDiag(minTurn);
                  stateV  = aiVertical(minTurn);
                  if(stateH || stateD || stateV) {
                      return;
                  }
              }
          }
          // Всегда начинаем с центра
        if(!middleState){
            //обработка центра
            if (map[middleColumn][middleColumn] == DOT_EMPTY) {
                map[middleColumn][middleColumn] = DOT_O;
                prevAiRow = middleColumn;
                prevAiColumn = middleColumn;
                return;
            } else if (map[middleColumn][middleColumn + 1] == DOT_EMPTY) {
                map[middleColumn][middleColumn + 1] = DOT_O;
                prevAiRow = middleColumn;
                prevAiColumn = middleColumn + 1;
                return;
            } else if (map[middleColumn - 1][middleColumn - 1] == DOT_EMPTY) {
                map[middleColumn][middleColumn - 1] = DOT_O;
                prevAiRow = middleColumn;
                prevAiColumn = middleColumn - 1;
                return;
            } else {
                middleState = true;
            }
            //Сначала ищем последовательность содержащую prevAiRow Column для этого можно использовать, измененный метод checkWin
        }
        if (aiVerticalSearch(false) || aiDiagSearch(false) || aiHorizontalSearch(false)) {
            return;
        }
        if (aiVerticalSearch(true) || aiDiagSearch(true) || aiHorizontalSearch(true)) {
            return;
        }
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
