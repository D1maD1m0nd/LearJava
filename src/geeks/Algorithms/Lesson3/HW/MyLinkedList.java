package geeks.Algorithms.Lesson3.HW;

import geeks.Algorithms.Lesson3.HW.Link;

public class MyLinkedList<T> {
    private Link<T> first;
    private Link<T> last;
    private Link<T> l = new Link<>();
    public MyLinkedList(){
        first = null;
        this.last = l;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void  insert(T link){
        Link<T> prevLink = l;
        l.setLink(link);
        l.setNext(first);
        this.first = l;
        l = new Link<>();
        prevLink.setPrev(l);

    }

    public void displayLast(){
        Link<T> current = last;

        while (current != null){
            System.out.println(current.getValue());
            current = current.getPrev();
        }
    }

    public Link<T> delete(){
        Link<T> temp = first;
        first = first.getNext();
        return temp;
    }

    public void display(){
        Link<T> current = first;
        while (current != null){
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }
    public T find(T searchNode){
        Link<T> findNode = new Link<>(searchNode);
        Link<T> current = first;
        while (current != null){
            if(current.getValue().equals(findNode.getValue())){
                return findNode.getValue();
            }
            current = current.getNext();
        }
        return null;
    }
}
