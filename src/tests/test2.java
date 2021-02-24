package tests;

public class test2 {
    public static final int[] Arr;
    public static final int[][] Arr1;
    public static final int SIZE_TO_WIN;
    public static final int ARR_LEN;
    public static int diagArrLen;
    //arr^2 * 2 ARR_LEN
    public static int[][][] ArrDiag;
    public static int[][][] ArrVertical;
    public static int[][] ArrHorizontal;

    static {

        Arr1 = new int[][]{{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 4, 5}};
        Arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        SIZE_TO_WIN = 3;

        ARR_LEN = Arr1.length;
        diagArrLen = collectingMainDiagonalSequences(false);
        ;
        ArrDiag = new int[diagArrLen][SIZE_TO_WIN][2];
        ArrVertical = new int[ARR_LEN * ARR_LEN * 2][SIZE_TO_WIN][2];
        ArrHorizontal = new int[ARR_LEN * ARR_LEN * 2][SIZE_TO_WIN];
    }

    public static void main(String[] args) {
        // checkAllVerticalVaiable();
        //  collectingVerticalSequences();
        collectingMainDiagonalSequences(true);
        collectingHorizontalSequences();
    }

    public static int collectingMainDiagonalSequences(boolean writeMode) {
        int start, end, rows = 0;
        for (int l = 0; l < ARR_LEN; l++) {
            if (SIZE_TO_WIN + l > ARR_LEN) {
                break;
            }
            for (int k = 0; k < ARR_LEN; k++) {

                start = l;
                end = ARR_LEN - 1 - l;
                if (SIZE_TO_WIN + k > ARR_LEN) {
                    break;
                }
                System.out.print("Основная ");
                for (int i = 0; i < SIZE_TO_WIN; i++) {
                    System.out.print(Arr1[start][i + k] + ",");
                    if (writeMode) {
                        ArrDiag[rows][i][0] = start;
                        ArrDiag[rows][i][1] = i + k;

                    }

                    start++;
                }
                rows++;
                System.out.print("Побочная ");
                for (int i = 0; i < SIZE_TO_WIN; i++) {
                    System.out.print(Arr1[i + k][end] + ",");
                    if (writeMode) {
                        ArrDiag[rows][i][0] = i + k;
                        ArrDiag[rows][i][1] = end;
                    }

                    end--;

                }
                System.out.println();
                rows++;
            }
        }
        return rows;
    }

    public static void collectingVerticalSequences() {
        int start, end, row = 0;
        for (int i = 0; i < ARR_LEN; i++) {

            for (int j = 0; j < ARR_LEN; j++) {
                start = j;
                end = ARR_LEN - 1 - j;
                if (j + SIZE_TO_WIN > ARR_LEN) {
                    break;
                }
                System.out.print("С начала ");
                for (int k = 0; k < SIZE_TO_WIN; k++) {
                    System.out.print(Arr1[start][i] + " ");
                    ArrVertical[row][k][0] = start;
                    ArrVertical[row][k][1] = i;
                    start++;

                }
                row++;
                System.out.print("С конца ");
                for (int k = 0; k < SIZE_TO_WIN; k++) {
                    System.out.print(Arr1[end][i] + " ");
                    ArrVertical[row][k][0] = end;
                    ArrVertical[row][k][1] = i;
                    end--;

                }
                row++;
            }

            System.out.println();

        }
        System.out.println();
    }

    public static void collectingHorizontalSequences() {
        int start, end, row = 0;
        for (int i = 0; i < ARR_LEN; i++) {
            start = i;
            end = ARR_LEN - 1 - i;
            if (start + SIZE_TO_WIN > ARR_LEN) {
                break;
            }
            for (int j = 0; j < SIZE_TO_WIN; j++) {
                System.out.print(Arr[start]);
                ArrHorizontal[row][j] = start;

                start++;
            }
            row++;
            System.out.print("   ");
            for (int j = 0; j < SIZE_TO_WIN; j++) {
                System.out.print(Arr[end]);
                ArrHorizontal[row][j] = end;
                end--;
            }
            row++;
            System.out.println();
        }
    }
}
