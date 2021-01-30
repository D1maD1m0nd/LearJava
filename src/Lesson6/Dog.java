package Lesson6;

public class Dog extends Animal{
    public static int countDog = 0;

    Dog(String name, int age, String color, double maxDistSwim, double maxDistRun){
        super(name,age,color, maxDistSwim,maxDistRun);
        countDog++;
    }
}
