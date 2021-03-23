package JavaRush.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    private static int counter;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(reader.readLine());
        counter(number1);
        int number2 = Integer.parseInt(reader.readLine());
        counter(number2);
        int number3 = Integer.parseInt(reader.readLine());
        counter(number3);
        System.out.println(counter);
    }

    private static void counter(int x) {
        if (x > 0) {
            counter++;
        }
    }
}
