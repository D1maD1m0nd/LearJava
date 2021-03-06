package geeks.Lesson4;

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
        if (currrentTurn < DOTS_TO_WIN - 1) {
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
    private static boolean aiVertical(int point, int mode) {
        char checkAbleSymbol = (mode == 0) ? DOT_O : DOT_X;
        //Вертикальное блокирование
        for (int[][] intsArr1 : ARR_VERTICAL) {
            if (mode == 0) {
                if (map[intsArr1[0][0]][intsArr1[0][1]] == DOT_X || map[intsArr1[DOTS_TO_WIN - 1][0]][intsArr1[DOTS_TO_WIN - 1][1]] == DOT_X)
                    continue;
            } else {
                if (map[intsArr1[0][0]][intsArr1[0][1]] == DOT_O || map[intsArr1[DOTS_TO_WIN - 1][0]][intsArr1[DOTS_TO_WIN - 1][1]] == DOT_O)
                    continue;
            }

            int dotColumn = -1;
            int dotRow = -1;
            int countStep = 0;
            int countQuanity = 0;
            for (int[] intsArr2 : intsArr1) {
                countStep++;
                int row = intsArr2[0];
                int column = intsArr2[1];

                if (map[row][column] == checkAbleSymbol && countQuanity != DOTS_TO_WIN - point) {
                    countQuanity++;
                } else if (map[row][column] == DOT_EMPTY) {
                    dotRow = row;
                    dotColumn = column;
                }
                if (countQuanity == DOTS_TO_WIN - point && countStep == DOTS_TO_WIN) {
                    if (dotColumn == -1 || dotRow == -1) {
                        continue;
                    }
                    map[dotRow][dotColumn] = DOT_O;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Блокирует горизонтальную последовательность и проверяет победу
     *
     * @param point количество элемент от которого необходимо произвести блок
     * @param mode  0 победы 1 проверка
     * @return возвращает true в случае блокирования хода аппонента
     */
    private static boolean aiHorizontal(int point, int mode) {

        int rows = 0;
        char checkAbleSymbol = (mode == 0) ? DOT_O : DOT_X;
        //что в строке есть нужное количество символов подряд
        for (char[] row : map) {

            for (int i = 0; i < SIZE; i++) {
                int dotColumn = -1;
                int countStep = 0;
                for (int[] ints : ARR_HORIZONTAL) {

                    if (mode == 0) {
                        //проверка на заполненность перебираемого значения
                        if (row[ints[0]] == DOT_X || row[ints[DOTS_TO_WIN - 1]] == DOT_X) continue;

                    } else {
                        //проверка на заполненность перебираемого значения
                        if (row[ints[0]] == DOT_O || row[ints[DOTS_TO_WIN - 1]] == DOT_O) continue;

                    }

                    int countQuanity = 0;
                    for (int index : ints) {
                        countStep++;
                        if (row[index] == checkAbleSymbol && countQuanity != DOTS_TO_WIN - point) {
                            countQuanity++;
                        } else if (row[index] == DOT_EMPTY) {
                            dotColumn = index;
                        }


                        if (countQuanity == DOTS_TO_WIN - point && countStep == DOTS_TO_WIN) {
                            if (dotColumn == -1) {
                                continue;
                            }
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
    private static boolean aiDiag(int point, int mode) {
        char checkAbleSymbol = (mode == 0) ? DOT_O : DOT_X;
        for (int[][] intsArr1 : ARR_DIAG) {
            if (mode == 0) {
                if (map[intsArr1[0][0]][intsArr1[0][1]] == DOT_X || map[intsArr1[DOTS_TO_WIN - 1][0]][intsArr1[DOTS_TO_WIN - 1][1]] == DOT_X)
                    continue;
            } else {
                if (map[intsArr1[0][0]][intsArr1[0][1]] == DOT_O || map[intsArr1[DOTS_TO_WIN - 1][0]][intsArr1[DOTS_TO_WIN - 1][1]] == DOT_O)
                    continue;

            }
            int dotColumn = -1, dotRow = -1, sideDiag = 0, mainDiag = 0, countQuanity = 0, countStep = 0;
            for (int[] intsArr2 : intsArr1) {
                countStep++;
                int row = intsArr2[0];
                int column = intsArr2[1];
                if (row == column) {
                    mainDiag++;
                } else {
                    sideDiag++;
                }
                if (map[row][column] == checkAbleSymbol && countQuanity != DOTS_TO_WIN - point) {
                    countQuanity++;
                } else if (map[row][column] == DOT_EMPTY) {
                    dotRow = row;
                    dotColumn = column;
                }
                if (countQuanity == DOTS_TO_WIN - point && countStep == DOTS_TO_WIN) {
                    if (dotColumn == -1 || dotRow == -1) {
                        continue;
                    }
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
                    if (row[ints[0]] == DOT_X || row[ints[DOTS_TO_WIN - 1]] == DOT_X) {
                        break;
                    }
                    for (int index : ints) {
                        if (prevAiColumn == index && prevAiRow == rows) {
                            if (row[index] == DOT_EMPTY) {
                                map[prevAiRow][index] = DOT_O;
                                return true;
                            }
                        } else if (searchNewReq && row[index] == DOT_EMPTY) {
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
                if (row == prevAiRow && column == prevAiRow) {
                    if (map[row][column] == DOT_EMPTY) {
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
                if (row == prevAiRow && column == prevAiColumn) {
                    if (map[row][column] == DOT_EMPTY) {
                        map[row][column] = DOT_O;
                        return true;
                    } else if (searchNewReq && map[row][column] == DOT_EMPTY) {
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
        // minTurn Минимальное число последовательности для блокировки с округление в больную сторону
        //maxTurn переменная для провервки максимального хода для проверки выигрыша в данном случа n-1
        //middleColumn центр поля
        int minTurn = DOTS_TO_WIN / 2, maxTurn = 1, middleColumn = SIZE / 2;
        //состояния проверки
        boolean stateH = false, stateV = false, stateD = false;
        //Ищем выигрышную последовательность
        //Вычисляем ход. после которого необходимо вести проверку на выигрышную последовательность у крестиков или ноликов
        if (DOTS_TO_WIN - minTurn - 1 <= currrentTurn) {
            //Ищем выигрышную последовательность
            if (aiHorizontal(maxTurn, 0) || aiVertical(maxTurn, 0) || aiDiag(maxTurn, 0)) {
                return;
            }
            //1 проверка
            if (aiHorizontal(maxTurn, 1) || aiDiag(maxTurn, 1) || aiVertical(maxTurn, 1)) {
                return;
            }
            //2 проверка
            if (aiHorizontal(minTurn, 1) || aiDiag(minTurn, 1) || aiVertical(minTurn, 1)) {
                return;
            }
        }
        // Всегда начинаем с центра
        if (!middleState) {
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
            } else if (map[middleColumn][middleColumn - 1] == DOT_EMPTY) {
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
            System.out.println("Введите Y");
            y = scanner.nextInt() - 1;
            System.out.println("Введите X");
            x = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    private static boolean isCellValid(int x, int y) {//true если условие валидно, т.е. мы можем поставить символ в эту ячейку, false в иных случаях
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE && map[y][x] == DOT_EMPTY;
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
