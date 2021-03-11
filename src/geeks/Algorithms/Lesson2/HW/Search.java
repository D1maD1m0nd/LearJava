package geeks.Algorithms.Lesson2.HW;

public class Search {
    public static int linerSearch(int[] arr, int key){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == key){
                System.out.println("Линейный найденный элемент " + arr[i]);
                return i;
            }
        }
        return -1;
    }
    public static int linerSearch(String[] arr, String key){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(key)){
                System.out.println("Линейный найденный элемент " + arr[i]);
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
            int midVal = arr[middle];
            if(midVal == key){
                //System.out.println("Бинарный поиск найденный элемент " + arr[middle]);
                return middle;
            }else if(midVal < key){
                left = middle + 1;
            }else if(midVal > key){
                right = middle - 1;
            }

        }
        return -1;
    }
    public static  int  binnarySearch(String elem, String[] arr){
        int firstIndex = 1;
        int lastIndex = arr.length - 1;

        while (firstIndex <= lastIndex){
            int middleIndex = (firstIndex + lastIndex) >>> 1;
            if(arr[middleIndex].equals(elem)){
                return middleIndex;
            }else if(arr[middleIndex].compareTo(elem) < 0){
                firstIndex = middleIndex + 1;
            } else if(arr[middleIndex].compareTo(elem) > 0){
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }
}
