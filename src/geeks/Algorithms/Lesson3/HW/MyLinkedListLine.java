package geeks.Algorithms.Lesson3.HW;

public class MyLinkedListLine<T> {

    private Link<T> first;
    public MyLinkedListLine() {
        first = null;

    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(T link) {
        Link<T> l = new Link<>();
        l.setLink(link);
        l.setNext(first);
        this.first = l;


    }

    public Link<T> delete() {
        Link<T> temp = first;
        first = first.getNext();

        return temp;
    }


    public void display() {
            Link<T> current = first;
            while (current != null) {
                System.out.println(current.getValue());
                current = current.getNext();
            }
    }

    public T find(T searchNode) {
        Link<T> findNode = new Link<>(searchNode);
        Link<T> current = first;

        while (current != null) {
            if (current.getValue().equals(findNode.getValue())) {
                System.out.println("Next find");
                return findNode.getValue();
            }

            current = current.getNext();

        }
        return null;
    }
}
