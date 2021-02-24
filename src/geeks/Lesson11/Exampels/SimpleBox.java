package geeks.Lesson11.Exampels;

public class SimpleBox<T> {
    private T object;


    SimpleBox(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
