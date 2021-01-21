package Lesson3;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Task2 {
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
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot","cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        startGameGuessWord(words);
    }
    public static String getRandomWordIntoArray(String[] arr){
        if(arr.length == 0){
            return "-1";
        }
        return arr[new Random().nextInt(arr.length)];
    }
    public static boolean equalsWords(String usrWord, String guessWord){
        return usrWord.equals(guessWord);
    }
    public static void printMaskArray(char[] arr){

        System.out.println("Буквы, которые удалось сопоставить");
        for (char val:
             arr) {
            System.out.print(val);
        }
        System.out.println();
    }
    public static void printPartGuessWord(String usrWord, String guessWord){
        char[] mask = {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'};
        String min = usrWord.length() > guessWord.length() ? guessWord : usrWord;
        int usrWordLen = min.length();
        for (int i = 0; i < usrWordLen; i++) {
            if(usrWord.charAt(i) == guessWord.charAt(i)){
                mask[i] = usrWord.charAt(i);

            }
        }
        printMaskArray(mask);
    }
    public static void startGameGuessWord(String[] arr){
        String randomWord = getRandomWordIntoArray(arr);
        Scanner scan = new Scanner(System.in);
        String usrAnswer;
        boolean gameOn;
        do {
            System.out.print("Введите загаданное слово: ");
            usrAnswer = scan.next();
            gameOn = equalsWords(usrAnswer,randomWord);
            if(gameOn){
                System.out.println("Поздравляю вы победили");
                break;
            }
            System.out.println("Увы, но вы не угадали");
            printPartGuessWord(usrAnswer,randomWord);
        }while (true);
    }
}
