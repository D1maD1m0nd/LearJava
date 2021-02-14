package geeks.Lesson9.HW;


public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static final ErrorDescription eDescipt = new ErrorDescription();
    public static void main(String[] args) {
        String[][] arr = {{"1","3","3","4"},{"1","2 ","3","4"},{"1","2","3","4"},{"1","e","в","4"}};
        try{
            sumArray(arr);
        }catch (MyArraySizeException  | MyArrayDataException e){
            //тут вызовется MyArrayDataException
            eDescipt.printInfoError(e.getStackTrace(), e.getMessage());
        }

        String[][] arr1 = {{"1","3","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
        try{
            sumArray(arr1);

        }catch (MyArraySizeException  | MyArrayDataException e){
            //тут вызовется MyArraySizeException
            eDescipt.printInfoError(e.getStackTrace(), e.getMessage());
        }
    }

    public static void sumArray(String[][] arr) throws MyArraySizeException,MyArrayDataException{

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
        for (String[] strings : arr) {
            for (String elem : strings) {
                //убираем пробелы, так как с ними по факту число тоже должно быть числом, в других языках именно так
                elem = elem.trim();
                //пример изи шарпа Convert.ToInt32("1232323          ") даст число, а не исключение
                //я хотел ловить намбер формат, но вроде смысл задания как раз писать свою обработку , поэтому использ0овал проверку через регулярку
                if (elem.matches("[0-9]+")) {
                    sum += Integer.parseInt(elem);
                } else {
                    System.out.println("Не полная сумма элементов массива равна: " + sum);
                    throw new MyArrayDataException(eDescipt.printProblemElements(arr));
                }
            }
        }

        System.out.println("Сумма элементов массива: " + sum);

    }
}
