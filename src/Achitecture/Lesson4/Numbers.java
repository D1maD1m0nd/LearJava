package Achitecture.Lesson4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Numbers implements Number{
    private final Random rand = new Random();
    private final List<Integer> numbers = new ArrayList<>();
    private int sum;
    @Override
    public Numbers sum() {
        for (int item: numbers) {
            sum += item;
        }
        return this;
    }
    public int getSum(){
        return sum;
    }


    @Override
    public Numbers addNumber(int number) {
        numbers.add(rand.nextInt() * number);
        return this;
    }
}
