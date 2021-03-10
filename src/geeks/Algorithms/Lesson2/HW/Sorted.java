package geeks.Algorithms.Lesson2.HW;

public class Sorted {
    public static  void bubbleSort(int[] arr){
        int len = arr.length;
        for (int i = len - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j+1] < arr[j]){
                    swap(j+1, j, arr);
                }
            }
        }
    }
    public static void choiceSorted(int arr[]){
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i+1; j < len; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(i,min,arr);
        }
    }

    public static void includeSorted(int[] arr){
        int in,buf;
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            buf = arr[i];
            in = i;
            while (in > 0 && arr[in - 1] >= buf){
                arr[in] = arr[in -1];
                --in;
            }
            arr[in] = buf;
        }
    }
    public static void swap(int first, int last, int[]arr){
        int buf = arr[first];
        arr[first] = arr[last];
        arr[last] = buf;
    }

}
