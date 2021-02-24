package geeks.Lesson11.HomeWork;

import java.util.ArrayList;
import java.util.Arrays;

public class Array<T> {
    private T[] values;

    public Array(T[] values) {
        this.values = values;
    }

    public T[] getValues() {
        return values;
    }

    public void setValues(T[] values) {
        this.values = values;
    }

    public void swap(int index1, int index2) {
        T buf = values[index1];
        values[index1] = values[index2];
        values[index2] = buf;
    }

    public ArrayList<T> arrayToArrayList(T[] elems) {
        return new ArrayList<T>(Arrays.asList(elems));
    }
}
