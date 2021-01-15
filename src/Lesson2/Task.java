package Lesson2;

public class Task {
    public static void main(String[] args) {
        //1.Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] arr = new int[]{1, 0, 1, 0, 0, 0, 0, 0, 0, 1};
        replaceZeroOne(arr);

        //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] arr2 = new int[8];
        writeDataIntoArray(arr2);

        //3.Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] arr3 = new int[]{ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplyValueIntoArray(arr3);

        //4.Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] arr4 = new int[][]{{0,0,0,0,0,0}, {0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
        writeOneDiagDataIntoArray(arr4);
    }

    /**
     * Изменяет значение 0 на 1 и наооборот в переданном массиве
     * @param arrZeroOne целочисленный массив содержащий 0 и 1
     *
     */
    static void replaceZeroOne(int[] arrZeroOne){
        int arrLen = arrZeroOne.length;
        for (int i = 0; i < arrLen ; i++) {
            if(arrZeroOne[i] == 0){
                arrZeroOne[i] = 1;
                continue;
            }
            arrZeroOne[i] = 0;

        }
    }

    /**
     * Метод заполняет массив последовательностью чисел умножения на 3  0 3 6 9 12 ...
     * @param arr - массив чисел
     */
    static void writeDataIntoArray(int[] arr){
        int arrLen = arr.length;
        for (int i = 0; i < arrLen; i++) {
            arr[i] = i * 3;
        }
    }

    static void multiplyValueIntoArray(int[] arr){
        int arrLen = arr.length;
        for (int i = 0; i < arrLen; i++) {
            if(arr[i] > 5){
                continue;
            }
            arr[i] *= 2;
        }
    }

    static void writeOneDiagDataIntoArray(int[][] arr){
        int arrLen1 = arr.length;
        int arrLen2 = arr[0].length;
        for (int i = 0; i < arrLen1; i++) {
            for (int j = 0; j < arrLen2; j++) {
                if(i == j){
                    arr[i][j] = 1;
                }
                if(arrLen2 -1  - i == j){
                    arr[i][arrLen2 - 1 - i] = 1;
                }

            }
        }
    }
}
