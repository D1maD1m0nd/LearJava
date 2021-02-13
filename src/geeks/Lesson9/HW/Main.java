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
        String[][] arr1 = {{"1","3","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
        try{
            sumArray(arr1);
        }catch (MyArraySizeException  | MyArrayDataException e){
            //тут вызовется MyArraySizeException
            System.out.println(e.getMessage());
        }
    }

    public static void sumArray(String arr[][]) throws MyArraySizeException,MyArrayDataException{
        int maxSizeRow = 4;
        int maxSizeColumn = 4;
        if(arr.length > maxSizeRow || arr.length < maxSizeRow){
            throw new MyArraySizeException();
        }else{
            //обрабатываем длинну элементов
            for (String [] item: arr) {
                if(item.length > maxSizeColumn || item.length < maxSizeColumn){
                    throw new MyArraySizeException();
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[i].length; k++) {
                //я хотел ловить намбер формат, но вроде смысл задания как раз писать свою обработку , поэтому использ0овал проверку через регулярку
                if (arr[i][k].matches("[0-9]+")){
                    sum += Integer.parseInt(arr[i][k]);
                }else{
                    System.out.println("Сумма элементов массива " + sum);
                    throw new MyArrayDataException("[" + Integer.toString(i) + "][" + Integer.toString(k) + "]", arr[i][k]);
                }
            }
        }
        System.out.println("Сумма элементов массива" + sum);

    }
}
