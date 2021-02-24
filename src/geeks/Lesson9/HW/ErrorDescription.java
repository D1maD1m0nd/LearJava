package geeks.Lesson9.HW;

public class ErrorDescription {
    public void printInfoError(StackTraceElement[] e, String infoError) {
        System.out.println(infoError);
        for (Object elem : e) {
            System.out.println(Main.ANSI_RED + elem + Main.ANSI_RESET);
        }
    }

    public String printProblemElements(String[][] arr) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                String elem = arr[i][j].trim();
                if (!elem.matches("[0-9]+")) {
                    result.append(String.format("\n[%d][%d]  имеется ошибочное значение равное \"%s\", которое нельзя привести к числу ", i, j, elem));
                }
            }
        }
        return result.toString();
    }
}
