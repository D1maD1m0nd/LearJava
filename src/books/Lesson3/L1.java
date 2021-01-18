package books.Lesson3;

public class L1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        reverseArray(array);
        printArray(array);
        long f = 132323232;
        Math.pow((double)f,3);
        System.out.println();
    }
    public static void reverseArray(int[] array) {
        int[] arrayReverse = new int[array.length];
        for(int i = array.length - 1, j = 0; i >= 0; i--,j++){

            arrayReverse[j] = array[i];

        }
        for(int i = 0; i < array.length; i++){
            array[i] = arrayReverse[i];
        }
    }
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

        public static int min(int a, int b, int c) {
            if(a > b  && b > c){
                return c;
            }
            if(a < b && b < c){
                return b;
            }
            return a;
        }
}
