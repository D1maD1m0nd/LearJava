package Lesson3;

import java.util.Random;

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
        System.out.println(getRandomWordIntoArray(words));
    }
    public static String getRandomWordIntoArray(String[] arr){
        if(arr.length == 0){
            return "-1";
        }
        return arr[new Random().nextInt(arr.length - 1)];
    }
}
