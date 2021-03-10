package geeks.Algorithms.Lesson2;

import java.util.Arrays;
import java.util.Random;

public class Search {
    public static void main(String[] args) {
        int[] mArray;
        int[] mArrayCopy;
        mArray = new int[100000];
        int key = 3;

        Random rand = new Random();

        for (int i = 0; i < mArray.length; i++) {
            mArray[i] = rand.nextInt(6000);
        }
        Arrays.sort(mArray);
        for (int i = 0; i < mArray.length; i++) {
            if(mArray[i] == key){
                System.out.println("Success " + i);
            }
        }
        String[] arrStr = new String[]{"1","sq","321","123"};
        Arrays.sort(arrStr);
        System.out.println(Arrays.toString(arrStr));
        System.out.println(BinarySearch("321", arrStr));
        System.out.println(BinarySearch(key,mArray));
    }

    public static  int   BinarySearch(int elem, int[] arr){
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        while (firstIndex <= lastIndex){
            int middleIndex = (firstIndex + lastIndex) / 2;
            if(arr[middleIndex] == elem){
                return middleIndex;
            }
            if(arr[middleIndex] < elem){
                firstIndex = middleIndex + 1;
            }
            if(arr[middleIndex] > elem){
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }
    public static  int  BinarySearch(String elem, String[] arr){
        int firstIndex = 1;
        int lastIndex = arr.length - 1;

        while (firstIndex < lastIndex){
            int middleIndex = (firstIndex + lastIndex) / 2;
            if(arr[middleIndex].equals(elem)){
                return middleIndex;
            }
            if(arr[middleIndex].compareTo(elem) < 0){
                firstIndex = middleIndex + 1;
            }
            if(arr[middleIndex].compareTo(elem) > 0){
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }
    public static  int   BinarySearch(double elem, double[] arr){
        int firstIndex = 1;
        int lastIndex = arr.length - 1;

        while (firstIndex < lastIndex){
            int middleIndex = (firstIndex + lastIndex) / 2;
            if(arr[middleIndex] == elem){
                return middleIndex;
            }
            if(arr[middleIndex] < elem){
                firstIndex = middleIndex + 1;
            }
            if(arr[middleIndex] > elem){
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }
    public static  int   BinarySearch(char elem, char[] arr){
        int firstIndex = 1;
        int lastIndex = arr.length - 1;

        while (firstIndex < lastIndex){
            int middleIndex = (firstIndex + lastIndex) / 2;
            if(arr[middleIndex] == elem){
                return middleIndex;
            }
            if(arr[middleIndex] < elem){
                firstIndex = middleIndex + 1;
            }
            if(arr[middleIndex] > elem){
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }
}
