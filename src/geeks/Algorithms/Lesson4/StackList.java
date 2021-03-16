package geeks.Algorithms.Lesson4;

import geeks.Algorithms.Lesson3.HW.MyLinkedListLine;

public class StackList {
    private MyLinkedListLine<String> list;
    StackList(){
        list = new MyLinkedListLine<String>();
    }
    public void push(String name){
        list.insert(name);
    }

    public String pop(){
        return list.delete().getValue();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
    public void display(){
        list.display();
    }
}
