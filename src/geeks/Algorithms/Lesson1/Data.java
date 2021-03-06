package geeks.Algorithms.Lesson1;

import java.util.Objects;
import java.util.Random;

public class Data {
    private int data;
    private static int data1 = 555;
    public static int data3 = 5555;
    public Data(int data){
        this.data = data;
    }
    public void printData(){
        System.out.println("Абстрактный " +  data);
    }

    public static void printData1(){
        System.out.println("Абстрактный " + data1);
    }

    public <T> long lineSearch(T searchObj,T[] searchData){
        long t1 = System.nanoTime();
        for (T data: searchData) {
            if(compare(searchObj, data)){
                return System.nanoTime() - t1;
            }
        }
        return -1;
    }
    public <T> boolean compare(T elem1, T elem2){
        return elem1.equals(elem2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data1 = (Data) o;
        return data == data1.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
