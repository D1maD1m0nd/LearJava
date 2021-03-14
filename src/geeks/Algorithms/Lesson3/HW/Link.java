package geeks.Algorithms.Lesson3.HW;

public class Link<T> {
    private T link;
    private Link<T> next;
    private Link<T> prev;

    Link(T link) {
        this.link = link;
    }

    Link() {

    }

    public void setLink(T link) {
        this.link = link;
    }

    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    public Link<T> getPrev() {
        return prev;
    }

    public void setPrev(Link<T> prev) {
        this.prev = prev;
    }

    public T getValue() {
        return link;
    }
}
