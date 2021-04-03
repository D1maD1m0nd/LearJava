package Achitecture.Lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TableNumber implements Number{
    private final Random rand = new Random();
    private final List<Integer[]> numbers = new ArrayList<>();
    private int sum;


    @Override
    public Number sum() {
        for (Integer[] item:numbers) {
            for (int item1: item) {
                sum += item1;
            }
        }
        return this;
    }

    @Override
    public Number addNumber(int number) {

        numbers.add(new Integer[number]);
        for (Integer[] item:numbers) {
            Arrays.fill(item,rand.nextInt());
        }
        return this;
    }

    @Override
    public int getSum() {
        return sum;
    }
}
