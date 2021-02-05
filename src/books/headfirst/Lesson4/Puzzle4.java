package books.headfirst.Lesson4;

import static java.lang.System.*;

public class Puzzle4 {
    public static void main(String[] args) {

        Puzzle4b[] obs = new Puzzle4b[6];
        int y = 1;
        int x = 0;
        int result = 0;
        while (x < 6){
            obs[x] = new Puzzle4b();
            obs[x].ivar = y;
            out.println(y);
            y = y * 10;

            x = x + 1;
        }
        x = 6;

        while (x > 0){
            x = x - 1;
            result = result + obs[x].doStuff(x);
        }
        String s1 = "1234";
        String s2 = new String("1234");
        out.println("Результат " + result);
        out.println(s1.equals(s2));
    }

}
