package books.headfirst.Lesson3;

public class textArray {
    public static void main(String[] args) {
        String[] island = new String[4];
        island[0] = "Island";
        island[1] = "Island1";
        island[2] = "Island2";
        island[3] = "Island3";
        int[] index = new int[4];
        index[0] = 1;
        index[1] = 3;
        index[2] = 0;
        index[3] = 2;

        int y = 0;
        int ref;
        while (y < 4) {
            ref = index[y];
            System.out.println(island[ref]);
            y++;
        }
    }
}
