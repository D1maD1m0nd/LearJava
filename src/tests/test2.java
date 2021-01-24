package tests;

public class test2 {
    public static int[] Arr;
    public static int[][] Arr1 = {{1,2,3,4},{1,2,3,4}, {1,2,3,4},{1,2,3,4}};
    public static final int SIZE_TO_WIN;

    static {
        Arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        SIZE_TO_WIN = 3;
    }

    public static void main(String[] args) {
       // checkAllVerticalVaiable();
        checkAllHorizlontalVariable();
    }
    public static void checkAllHorizlontalVariable(){
        int start, end;
        for (int i = 0; i < Arr1.length; i++) {
            end = Arr1.length - 1 - i;
            for (int j = 0; j < Arr1.length; j++) {
                start = j;
                if(j + SIZE_TO_WIN > Arr1.length){
                    break;
                }
                for (int k = 0; k < SIZE_TO_WIN; k++) {
                    System.out.print(Arr1[start][i]);
                    start++;

                }
                System.out.print(" ");
            }

            System.out.println();

        }
//            System.out.print(" ");
//            for (int[] ints : Arr1) {
//                System.out.print(ints[Arr1.length - 1  - i]);
//            }
            System.out.println();
        }

    public  static void checkAllVerticalVaiable(){
        int start, end;
        for (int i = 0; i < Arr.length; i++) {
            start = i;
            end = Arr.length - 1 - i;
            if(start + SIZE_TO_WIN > Arr.length){
                break;
            }
            for (int j = 0; j < SIZE_TO_WIN; j++) {
                System.out.print(Arr[start]);

                start++;
            }
            System.out.print("   ");
            for (int j = 0; j < SIZE_TO_WIN; j++) {
                System.out.print(Arr[end]);
                end--;
            }
            System.out.println();
        }
    }
}
