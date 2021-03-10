package geeks.Algorithms.Lesson2;

import java.util.Arrays;
import java.util.Random;

public class SortedTes {
    public static void main(String[] args) {
        int[] mArray = new int[20];
        int[] mArrayCopy;
        int buf;
        boolean isSort = false;

        Sorted sort = new Sorted(20);
        Random rand = new Random();

        for (int i = 0; i < mArray.length; i++) {
            mArray[i] = rand.nextInt(1000000);
            sort.intoArr(rand.nextInt(1000000));
        }

        mArrayCopy = Arrays.copyOf(mArray,mArray.length);
        System.out.println("un Sorted " + Arrays.toString(mArray));
        while (!isSort){
            isSort = true;
            for (int i = 0; i < mArray.length - 1; i++) {
                if(mArray[i] > mArray[i + 1]){
                    isSort = false;
                    buf = mArray[i];
                    mArray[i] = mArray[i+1];
                    mArray[i + 1] = buf;
                }
            }
        }
        sort.bubleSort();
        System.out.println("Sorted " + Arrays.toString(mArray));
    }
}
