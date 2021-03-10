package geeks.Algorithms.Lesson2;

public class Sorted {
    private long[] arr;
    private int max;
    private int elem = 0;

    Sorted(int aMax){
        max = aMax;
        arr =  new long[max];
    }
    public void setMax(int max) {
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    public void intoArr(long value){
        arr[elem] = value;
        elem++;
    }
    public void setArr(long[] arr) {
        this.arr = arr;
    }

    public long[] getArr() {
        return arr;
    }
    public void swapM(int first, int last){
        long buf = arr[first];
        arr[first] = arr[last];
        arr[last] = buf;
    }
    public void bubleSort(){
        for(int i = elem - 1; i >= 1; i-- ){
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j + 1]){
                    swapM(j,j+1);
                }
            }
        }
    }
}
