package geeks.Algorithms.Lesson3;

public class Link <T> {
    private T link;
    private Link<T> next;
    Link(T link){
        this.link = link;
    }
    public Link<T> getNext(){
        return next;
    };
    public void setNext(Link<T> next){
        this.next = next;
    }
    public T getValue(){
        return link;
    }
}
