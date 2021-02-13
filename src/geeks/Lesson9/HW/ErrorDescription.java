package geeks.Lesson9.HW;

public class ErrorDescription {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    public void printInfoError (StackTraceElement[] e, String infoError){
        System.out.println(infoError);
        for (Object elem: e) {
            System.out.println(ANSI_RED + elem + ANSI_RESET);
        }
    }
    public String printProblemElements(String[][] arr){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                String elem = arr[i][j].trim();
                if (!elem.matches("[0-9]+")){
                    result.append(String.format("\n[%d][%d]  имеется ошибочное значение равное \"%s\", которое нельзя привести к числу ", i, j, elem));
                }
            }
        }
        return result.toString();
    }
}
