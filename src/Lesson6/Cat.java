package Lesson6;

public class Cat extends Animal{
    private static int count = 0;
    Cat(String name,  double maxDistRun){
        super(name,maxDistRun);
        count++;
    }
    public void swim(double let){
        System.out.printf("%s является котом, а коты не умеют плавать \n", getName());

    }

    public static int getCount(){
        return count;
    }

}
