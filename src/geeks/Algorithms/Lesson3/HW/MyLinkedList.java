package geeks.Algorithms.Lesson3.HW;

public class MyLinkedList<T> {
    private final Link<T> last;
    private Link<T> first;
    private Link<T> l = new Link<>();

    public MyLinkedList() {
        first = null;
        this.last = l;
    }

    public boolean isEmpty() {
        return first == null || last.getPrev() == null;
    }

    public void insert(T link) {
        Link<T> prevLink = l;
        l.setLink(link);
        l.setNext(first);
        this.first = l;
        l = new Link<>();
        prevLink.setPrev(l);

    }

    public Link<T> delete() {
        Link<T> temp = first;
        first = first.getNext();

        return temp;
    }


    public void display(boolean reverse) {
        if (reverse) {
            Link<T> current = last;
            while (current.getPrev() != null) {
                System.out.println(current.getValue());
                current = current.getPrev();
            }
        } else {
            Link<T> current = first;
            while (current != null) {
                System.out.println(current.getValue());
                current = current.getNext();
            }
        }

    }

    public T find(T searchNode) {
        Link<T> findNode = new Link<>(searchNode);
        Link<T> current = first;
        Link<T> currentL = last;
        while (current != null && currentL.getPrev() != null) {
            if (current.getValue().equals(findNode.getValue())) {
                System.out.println("Next find");
                return findNode.getValue();
            }
            if (currentL.getValue().equals(findNode.getValue())) {
                System.out.println("Prev find");
                return findNode.getValue();
            }
            current = current.getNext();
            currentL = currentL.getPrev();
        }
        return null;
    }
}
