package tests;

public class test1 {
    public static void main(String[] args) {
        int[] a = new int[10000000];
        int arrLen = a.length;
        double finalTime = 0;
        long b = 0L;
        for (int j = 0; j < 1000; j++) {
            b = 0;
            long startTime = System.currentTimeMillis();

            {
                //какой- то код, скорость работы которого нужно оценить
                for (int i = 0; i < arrLen; i++) {
                    b++;
                }
            }

//время затраченное на выполнение кода
            long time = System.currentTimeMillis() - startTime;
            finalTime += time;
        }
        System.out.println("1 " + finalTime / 1000);

        for (int j = 0; j < 1000; j++) {
            b = 0;
            long startTime = System.currentTimeMillis();

            {
                //какой- то код, скорость работы которого нужно оценить
                for (int i = 0; i < a.length; i++) {
                    b++;
                }
            }

//время затраченное на выполнение кода
            long time = System.currentTimeMillis() - startTime;
            finalTime += time;
        }
        System.out.println("2 " + finalTime / 1000);
    }

}
