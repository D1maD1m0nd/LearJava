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
        int[][] arr4 = new int[6][6];
        writeOneDiagDataIntoArray(arr4);

        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] arr5 = new int[]{ 1, 1, 1, 2, 1};
        searchMinMaxIntoArr(arr5);

        //6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
        boolean b = checkBalance(arr5);

        //7. Я не осилил, ниже реализован мой тетод, но работает нормально, только по длинна меньше сдвига плюс текущий индекс
        int[] arr6 = new int[]{3, 5, 6, 1};
        // это моя реализация метода, но он нормально работает для сдвига вправо, но и то не всегда
        biasElemArr(arr6,-2);


        int[]arr7 = new int[]{1,2,3};
        biasRightNew(arr7,1);
        int[]arr8 = new int[]{ 3, 5, 6, 1};
        biasLeftNew(arr8, -2);
        //biasElemArr(arr7,-2);
        //biasElemArr(arr8,2);



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

    /**
     * Умножает элементы на 2 , которые соответствуют условия arr[i] > 5(элементы меньше 6)
     * @param arr целочисленный массив
     */
    static void multiplyValueIntoArray(int[] arr){
        int arrLen = arr.length;
        for (int i = 0; i < arrLen; i++) {
            if(arr[i] > 5){
                continue;
            }
            arr[i] *= 2;
        }
    }

    /**
     * Заполняет Квадратный массив по двум диагоналям
     * @param arr двуммерный квадратный массив
     */
    static void writeOneDiagDataIntoArray(int[][] arr){
        int arrLen = arr.length;
        for (int i = 0; i < arrLen; i++) {
            for (int j = 0; j < arrLen ; j++) {
                if(i == j){
                    arr[i][j] = 1;
                }
                if(arrLen -1  - i == j){
                    arr[i][arrLen - 1 - i] = 1;
                }

            }
        }
    }

    /**
     * Ищет минимальный и максимальный элемент массив
     * @param arr массив целых чисел
     */
    static void searchMinMaxIntoArr(int[] arr){
        int max = arr[0];
        int min = arr[0];
        for (int j : arr) {
            if (j >= max) {
                max = j;
            }
            if (j <= min) {
                min = j;
            }
        }
        System.out.println("Минимальный элемент массива: " + min + ", Максимальный элемент массива: " + max);
    }

    /**
     * Проверяет эквивалентность правой и левой части массива
     * @param arr - целочисленный массив
     * @return true для случая если сумма правой и левой части равны
     */
    static boolean checkBalance(int[] arr){
        int arrLen = arr.length;
        //Проверка на пустой массив
        if(arrLen == 0){
            return false;
        }
        int sumRight;
        int sumLeft;
        for (int i = 0; i < arrLen; i++) {
            sumRight = sumArrRight(arr, i);
            sumLeft = sumArrLeft(arr,i);
            if(sumLeft == sumRight){
                return true;
            }
        }
        return false;
    }

    /**
     * Вычисление правой части массива с смещением
     * @param arr целочисленный массив смещение
     * @param bias смещение
     * @return сумма правой части
     */
    static int sumArrRight(int[] arr, int bias){
        int arrLen = arr.length;
        int sumRight = 0;
        for (int i = 0; i < arrLen - bias; i++) {
            sumRight += arr[i];
        }
        return sumRight;
    }
    /**
     * Вычисление левой части массива с смещением
     * @param arr целочисленный массив смещение
     * @param bias смещение
     * @return сумма левой части
     */
    static  int sumArrLeft(int[] arr, int bias){
        int arrLen = arr.length;
        int sumLeft = 0;
        for (int i = arrLen - bias; i < arrLen; i++) {
            sumLeft += arr[i];
        }
        return sumLeft;
    }

    /**
     *
     * старый метод вычисления сдвига
     */
    static void biasElemArr(int[] arr, int n){
       if(n > 0){
           biasRight(arr,n);
       }
       else{
           biasLeft(arr,n);
       }

    }
    static void biasRight(int[] arr,int n){
        int arrLen = arr.length;
        int buf;
        if(n > arrLen - 1){
            return;
        }
        for (int i = 0; i < arrLen-1; i++) {
            buf = arr[0];
            if(i+n < arrLen){

                arr[0] = arr[i + n];
                arr[i + n] = buf;
            }
            if(i+n == arrLen){

                arr[0] = arr[arrLen - n];
                arr[arrLen - n] = buf;
            }
        }
    }

    static void biasLeft(int[] arr, int n) {
        int arrLen = arr.length;
        int buf;
        if (n > arrLen - 1) {
            return;
        }
        for (int i = arrLen -1; i >= 0; i--) {
            buf = arr[arrLen - 1];
            if (i + n >= 0) {

                arr[arrLen - 1] = arr[i + n];
                arr[i + n] = buf;
            }
            if (i + n  < 0) {

                arr[arrLen - 1] = arr[arrLen + n];
                arr[arrLen + n] = buf;
            }
        }
    }

    static void biasRightNew(int[] arr,int n){
        int buf = 0;
        int arrLen = arr.length;

        for (int i = 0; i < n; i++) {

            buf = arr[0];
            arr[0] = arr[arrLen - 1];


            for (int j = 1; j < arrLen - 1; j++) {
                arr[arrLen - j] = arr[arrLen - j - 1];
            }


            arr[1] = buf;
        }

    }
    static void biasLeftNew(int[] arr,int n){
        int buf = 0;
        int arrLen = arr.length;
        for (int i = 0; i > n; i--) {
            buf = arr[arrLen - 1];
            arr[arrLen - 1] = arr[0];

            for (int j = 1; j < arrLen - 1; j++) {
                arr[j - 1] = arr[j];
            }

            arr[arrLen - 2] = buf;
        }
    }
}
