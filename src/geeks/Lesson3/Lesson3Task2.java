package geeks.Lesson3;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Task2 {
    public static final String[] WORDS = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        /*
         *Создать массив из слов
         *  String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
         *  "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
         * "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}. При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
         * сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят
         * на своих местах. apple – загаданное apricot - ответ игрока ap############# (15 символов, чтобы пользователь не мог узнать длину слова) Для сравнения
         * двух слов посимвольно можно пользоваться:
         * String str = "apple"; char a = str.charAt(0); - метод, вернет char,
         * который стоит в слове str на первой позиции Играем до тех пор, пока игрок не отгадает слово. Используем только маленькие буквы.
         */


        startGameGuessWord();
    }

    /**
     * Выбирает случайное слово из коллекции
     *
     * @return возвращает строку содержащую слово из массива, который был передан в парметре, в случае пустого массива возвращает -1
     */
    public static String getRandomWordIntoArray() {
        return WORDS[new Random().nextInt(WORDS.length)];
    }

    /**
     * Производит сопоставление букв в загаданном и пользовательском слове
     *
     * @param usrWord   слово пользователя
     * @param guessWord загаданное слово
     */
    public static void printPartGuessWord(String usrWord, String guessWord) {
        char[] mask = new char[]{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
        int usrWordLen = Math.min(usrWord.length(), guessWord.length());
        char usrSymbol;
        for (int i = 0; i < usrWordLen; i++) {
            usrSymbol = guessWord.charAt(i);
            if (usrWord.charAt(i) == usrSymbol) {
                mask[i] = usrSymbol;

            }
        }
        System.out.printf("Буквы, которые удалось сопоставить %s \n", new String(mask));
    }

    /**
     * Метод начала игры
     */
    public static void startGameGuessWord() {
        String randomWord = getRandomWordIntoArray();

        String usrAnswer;

        do {
            System.out.print("Введите загаданное слово: ");
            usrAnswer = SCANNER.next();

            if (usrAnswer.equals(randomWord)) {
                System.out.println("Поздравляю вы победили");
                break;
            }
            System.out.println("Увы, но вы не угадали");
            printPartGuessWord(usrAnswer, randomWord);
        } while (true);
    }
}
