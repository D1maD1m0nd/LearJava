package books.headfirst.Lesson1;

public class Lesson1L2 {
    public static void main(String[] args) {
        String[] wordListOne = {
                "круглосуточный", "трехзначный", "3000-футовый", "взаимный", "невероятный", "злой"
        };
        String[] wordListTwo = {
                "уполномоченный", "трудный", "чистый продуктв", "ориентированный"
        };
        String[] wordListThree = {"процесс", "пункт разгрузки", "выходи и положения", "тип структуры"};

        int oneLen = wordListOne.length;
        int twoLen = wordListTwo.length;
        int threeLen = wordListThree.length;

        int rand1 = (int) (Math.random() * oneLen);
        int rand2 = (int) (Math.random() * twoLen);
        int rand3 = (int) (Math.random() * threeLen);

        String phrase = wordListOne[rand1] + " " +
                wordListTwo[rand2] + " " + wordListThree[rand3];

        System.out.println("Все что нам нужно, - это  " + phrase);
    }

}
