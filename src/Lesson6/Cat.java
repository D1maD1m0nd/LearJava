package Lesson6;

public class Cat extends Animal{
    public static int countCat = 0;
    private final double maxDistanseSwim = 0;
    Cat(String name, int age,String color, double maxDistRun){
        super(name,age,color,maxDistRun);
        Cat.countCat++;
    }
    public void swim(double let){
        System.out.printf("%s является котом, а коты не умеют плавать \n", name);

    }

}
