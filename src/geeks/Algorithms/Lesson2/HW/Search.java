package geeks.Algorithms.Lesson2.HW;

public class Search {
    public static int linerSearch(int[] arr, int key){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }
    public static int linerSearch(String[] arr, String key){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(key)){
                return i;
            }
        }
        return -1;
    }
    public static int binnarySearch(int[] arr, int key){
        int left = 1;
        int right = arr.length - 1;
        while (right >= left){
            int middle = (left + right)/2;
            if(arr[middle] == key){
                return middle;
            }
            if(arr[middle] < key){
                left = middle + 1;
            }

            if(arr[middle] > key){
                right = middle - 1;
            }

        }
        return -1;
    }
    public static  int  binnarySearch(String elem, String[] arr){
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        while (firstIndex <= lastIndex){
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
}
