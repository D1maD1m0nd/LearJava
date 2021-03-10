package geeks.Algorithms.Lesson2;

public class SortedGet {
    public static void gettingSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swapM(i,min,arr);
        }
    }
    public static void swapM(int first, int last, int arr[]){
        int buf = arr[first];
        arr[first] = arr[last];
        arr[last] = buf;
    }
}
