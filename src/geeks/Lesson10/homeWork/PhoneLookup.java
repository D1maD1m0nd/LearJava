package geeks.Lesson10.homeWork;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneLookup {

    private final Map persons;

    PhoneLookup() {

        persons = new HashMap();
    }

    //это надо переделать
    public void add(String lastName, String phoneNumber) {
        Set value = new HashSet();
        if (persons.containsKey(lastName)) {
            value = (Set) persons.get(lastName);
        }
        value.add(phoneNumber);
        persons.put(lastName, value);
    }

    public String get(String lastName) {
        if (persons.containsKey(lastName)) {
            return persons.get(lastName).toString();
        }
        return "Человек с такой фамилией не найден";
    }
}