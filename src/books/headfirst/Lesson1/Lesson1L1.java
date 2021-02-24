package books.headfirst.Lesson1;

public class Lesson1L1 {
    public static void main(String[] args) {
        int beerNum = 99;
        String word = "бутылок";
        int remainder = 0;
        while (beerNum > 0) {
            remainder = beerNum % 10;
            if (remainder == 1 && remainder != 11) {
                word = "бутылка";
            } else if (remainder >= 2 && remainder <= 4 && !(beerNum >= 12 && beerNum <= 14)) {
                word = "бытылки";
            } else {
                word = "бутылок";
            }
            System.out.println("\n" + beerNum + " " + word + " пива на стене");
            System.out.println(beerNum + " " + word + " пива");
            System.out.print("Возьми одну  Пусти по кругу \n");
            beerNum = beerNum - 1;
            if (beerNum > 0) {
                System.out.println(beerNum + " " + word + " пива на стене");
            } else {
                System.out.println("Нет бутылок пива на стене\n");
            }
        }
    }
}
