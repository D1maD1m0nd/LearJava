package geeks.Algorithms.Lesson4;

import geeks.Algorithms.Lesson3.HW.MyLinkedListLine;

public class Queuq {

    private final MyLinkedListLine<String> list;
    public Queuq(){
        list = new MyLinkedListLine<String>();

    }
    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void insert(String elem){
        list.insert(elem);
    }

    public String delete(){
        return list.delete().getValue();
    }
    public void display(){
        list.display();
    }
}
