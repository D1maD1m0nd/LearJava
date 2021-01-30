package Lesson6;

public class Dog extends Animal{
    private static int count;

    Dog(String name,  double maxDistSwim, double maxDistRun){
        super(name, maxDistSwim,maxDistRun);
        count++;
    }
    public static int getCount(){
        return count;
    }
}
