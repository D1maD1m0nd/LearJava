package geeks.Lesson10.homeWork;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneLookup {

    private Map persons;
    PhoneLookup(){
        persons = new HashMap();
    }
    //это надо переделать
    public void add(String lastName, String phoneNumber){
        if(persons.containsKey(lastName)){
            //переделаю на коллекцию с строк
            String newValue = persons.get(lastName).toString() + phoneNumber + " " ;
            persons.put(lastName,newValue);
            return;
        }
        persons.put(lastName, phoneNumber + " ");
    }
    public String get(String lastName){
        return persons.get(lastName).toString();
    }
}
