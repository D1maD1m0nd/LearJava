package geeks.Lesson9.HW;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {{"1","3","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","e","3","4"}};

        try{
            sumArray(arr);
        }catch (MyArraySizeException  | MyArrayDataException e){
            //тут вызовется MyArrayDataException
            System.out.println(e.getMessage());
        }
        String[][] arr1 = {{"1","3","3","4"},{"1","2,","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","3","3","4"}};
        try{
            sumArray(arr1);
        }catch (MyArraySizeException  | MyArrayDataException e){
            //тут вызовется MyArraySizeException
            System.out.println(e.getMessage());
        }
    }

    public static void sumArray(String arr[][]) throws MyArraySizeException,MyArrayDataException{
        int maxSizeRow = 5;
        int maxSizeColumn = 5;
        if(Arrays.stream(arr).count() >= maxSizeRow || Arrays.stream(arr[0]).count() >= maxSizeColumn){
            throw new MyArraySizeException();
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[i].length; k++) {
                if (arr[i][k].matches("[0-9]+")){
                    sum += Integer.parseInt(arr[i][k]);
                }else{
                    System.out.println("Сумма элементов массива" + sum);
                    throw new MyArrayDataException("[" + Integer.toString(i) + "][" + Integer.toString(k) + "]", arr[i][k]);
                }
            }
        }
        System.out.println("Сумма элементов массива" + sum);

    }
}
