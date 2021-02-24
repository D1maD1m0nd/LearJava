package geeks.Lesson10.homeWork;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //10.1
        //Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        List words = new ArrayList(Arrays.asList("orange", "apple", "ananas", "phsphor", "ananas", "orange", "potato", "coolity", "hility", "potato", "potato", "seek", "think", "about", "think"));
        // Найти и вывести список уникальных слов,
        // из которых состоит массив (дубликаты не считаем).
        printOriginalWords(words);
        // Посчитать, сколько раз встречается каждое слово.
        countAllWords(words);

        //10.2
        //Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
        // В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
        // Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
        // Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем через консоль и т.д).
        // Консоль использовать только для вывода результатов проверки телефонного справочника.o
        System.out.println("Номера телефонов");
        PhoneLookup lookup = new PhoneLookup();
        lookup.add("Васильев", "+8922189642");
        lookup.add("Генералов", "+891234654");
        lookup.add("Васильев", "+8123467534");
        lookup.add("Викториянов", "+89432123");
        //тут проверяем то, что одинаковые номера не будут добавляться в коллекцию
        lookup.add("Викториянов", "+89432123");
        lookup.add("Васильев", "+812346753321");
        System.out.println("Васильев: " + lookup.get("Васильев"));
        System.out.println("Генералов: " + lookup.get("Генералов"));
        System.out.println("Данисимов: " + lookup.get("Данисимов"));
        System.out.println("Викториянов: " + lookup.get("Викториянов"));
    }

    /**
     * Вывод всех уникальных слов
     *
     * @param words - список уникальных слов
     */
    public static void printOriginalWords(List words) {
        System.out.println("Уникальные слова встречающиеся лишь один раз");
        for (Object word : words) {
            if (words.indexOf(word) == words.lastIndexOf(word)) {
                System.out.println(word);
            }
        }
    }

    public static void countAllWords(List words) {

        System.out.println("Подсчет каждого слова");
        Set wordOriginal = new HashSet(words);

        for (Object word : wordOriginal) {
            if (words.indexOf(word) == words.lastIndexOf(word)) {
                System.out.println(word + ": " + 1);
                continue;
            }
            int countWord = 0;
            for (Object word1 : words) {
                if (word.equals(word1)) {
                    countWord++;
                }
            }
            System.out.println(word + ": " + countWord);
        }
    }
}